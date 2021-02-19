var posts = []
var comments = []
var users = []
var todos = []
var albums = []
var userId

function selectUser(id) {
    userId = id
    getPosts()
    getTodos()
    getAlbums()
}

function getPosts() {
    fetch('https://jsonplaceholder.typicode.com/users/' + userId + '/posts')
        .then((response) => response.json())
        .then((data) => {
            posts = data
            document.getElementById('spinner').innerHTML = ""
            mapPosts()
        })
}

function getUsers() {
    fetch('https://jsonplaceholder.typicode.com/users')
        .then((response) => response.json())
        .then((data) => {
            users = data
            document.getElementById('spinner').innerHTML = ""
            mapUsers()
        })
}

function getTodos() {
    fetch('https://jsonplaceholder.typicode.com/users/' + userId + '/todos')
        .then((response) => response.json())
        .then((data) => {
            todos = data
            mapTodos()
        })
}

function getAlbums() {
    fetch('https://jsonplaceholder.typicode.com/users/' + userId + '/albums')
        .then((response) => response.json())
        .then((data) => {
            albums = data
            mapAlbums()
        })
}

function getComments(id) {
    fetch('https://jsonplaceholder.typicode.com/posts/' + id + '/comments')
        .then(response => response.json())
        .then(data => {
            comments = data
            mapComments(id)
        })
}

function mapPosts() {
    var postsCards = ""

    for (let index = 0; index < posts.length; index++) {
        postsCards +=
            "<div class='card my-2'>" +
            "<div class='card-body'>" +
            "<h5 class='card-title text-primary'>" + posts[index].title + "</h5>" +
            "<p class='card-text'>" + posts[index].body + "</p> " +
            "<button class='btn btn-primary' onclick='getComments(" + posts[index].id + ")'>View Comments</button>" +
            "<div id='" + posts[index].id + "'></div>" +
            "</div>" +
            "</div>"
    }

    document.getElementById("postsArea").innerHTML = postsCards
}

function mapComments(id) {
    var listComments = ""

    for (let index = 0; index < comments.length; index++) {
        listComments +=
            "<li class='list-group-item'>" +
            "<div class='row'>" +
            "<div class='col-sm-4 text-primary'>" + comments[index].email + "</div>" +
            "<div class='col-sm text-justify'>" + comments[index].body + "</div>" +
            "</div>" +
            "</li>"
    }

    document.getElementById(id).innerHTML = "<ul class='list-group my-2'>" + listComments + "</ul>"

}

function mapUsers() {
    var listUsers = ""

    for (let index = 0; index < users.length; index++) {
        listUsers +=
            "<a href='#' class='list-group-item list-group-item-action' onclick='selectUser(" + users[index].id + ")'>" + users[index].name + "</a>"
    }
    document.getElementById("usersListArea").innerHTML = listUsers

}

function mapTodos() {
    var listTodos = ""

    for (let index = 0; index < todos.length; index++) {
        listTodos +=
            "<li class='list-group-item d-flex justify-content-between align-items-center'>" +
            todos[index].title +
            "<span class=''>" + ((todos[index].completed) ? "<i class='material-icons text-success'>assignment_turned_in</i>" : "<i class='material-icons text-warning'>hourglass_top</i>") +
            "</span>" +
            "</li>"
    }
    document.getElementById("todosListArea").innerHTML =
        "<ul class='list-group mt-2'>" + listTodos + "</ul>"

}

function mapAlbums() {
    var listAlbums = ""

    for (let index = 0; index < albums.length; index++) {
        listAlbums +=
            "<div class='card my-2'>" +
            "<img src='download.png' alt='' class='card-img-top'>" +
            "<div class='card-body'>" +
            "<h5 class='card-title text-primary'>" + albums[index].title + "</h5>" +
            "</div>" +
            "</div>"

    }
    document.getElementById("albumsCardsArea").innerHTML =
        "<div class='card-columns'>" + listAlbums + "</div>"

}