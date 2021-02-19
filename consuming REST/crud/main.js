
var posts = [];

function getPosts() {
    // fetch('http://localhost:8080/postbook/webapi/postbook/posts/all')
    fetch('http://jsonplaceholder.typicode.com/posts')
        .then(res => res.json())
        .catch(err => {
            console.log(err)
        })
        .then(data => {
            posts = data;
            mapPosts()
        })
}

function mapPosts() {
    var postsArea = ''
    posts.forEach((post, index) => {
        postsArea +=
            "<div class='card my-2'>" +
            "<div class='card-body'>" +
            "<h4 class='card-title'>" + post.title + "</h4>" +
            "<h6 class='card-subtitle mb-2 text-muted'>" + "Posted By User:" + post.id + "</h6>" +
            "<p class='card-text'>" + post.body + "</p>" +
            "<div class='card-link'>" +
            "<button class='btn btn-danger btn-sm' onclick='deletePost(" + index + ")'>delete</button>" +
            "</div >" +
            "</div>" +
            "</div>"
    });
    document.getElementById('postsArea').innerHTML = postsArea
}

function addPost() {

    var title = document.getElementById("textTitle").value
    var body = document.getElementById("textBody").value

    var post = {
        id: 0,
        title: title,
        body: body
    }

    fetch('http://localhost:8080/postbook/webapi/postbook/posts/add', {
        method: 'POST',
        body: JSON.stringify(post),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(res => res.json())
        .then(data => {
            post.id = data.id
            console.log(data)
            posts.push(post)
            document.getElementById("textTitle").value = ''
            document.getElementById("textBody").value = ''

            mapPosts()
        })
}

function deletePost(index) {
    fetch('http://localhost:8080/postbook/webapi/postbook/posts/delete/' + posts[index].id, {
        method: 'DELETE',
        // body: JSON.stringify(post),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(res => res.json())
        .then(status => {
            console.log(status)
            if (status.queryStatus) {
                posts.splice(index, 1)
                mapPosts()
            }
        })
}


// 1. Get Data in Json Format from REST-API
// 2. Convert the data into JS Format 
// 3. Map it into UI (list, table, cards)