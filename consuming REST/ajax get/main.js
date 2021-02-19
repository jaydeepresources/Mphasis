var posts = [];

function mapPosts() {
    var cardsRef = document.getElementById('cards');
    cardsRef.innerHTML = "";

    for (var i = 0; i < posts.length; i++) {
        cardsRef.innerHTML +=
            "<div class='card mb-2' >" +
            "<div class='card-body' >" +
            "<h5 class='card-title'>" + posts[i].title + "</h5><hr/>" +

            "<p class='card-text'>"
            + posts[i].body +
            "</p>" +
            "</div>" +
            "</div>";
    }

}

function getPosts() {

    var xhr = new XMLHttpRequest();

    xhr.onload = function () {

        if (xhr.status >= 200 && xhr.status < 300) {
            posts = JSON.parse(xhr.response)
            console.log(posts)
            mapPosts()
        } else {
            console.log('The request failed!');
        }
    };

    xhr.open('GET', 'https://jsonplaceholder.typicode.com/posts')
    xhr.send()
}