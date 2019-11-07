import { Post } from './model/Post';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({
    'Authorization': 'someToken'
  }),
  withCredentials: true
};

@Injectable({
  providedIn: 'root'
})
export class PostsService {

  public posts: Post[]

  constructor(public http: HttpClient) {
    this.posts = []
  }

  getPosts() {
    return this.http.get('http://localhost:8080/posts/all', httpOptions)
  }

  addPost(post: Post) {
    return this.http.post('http://localhost:8080/posts/add', post, httpOptions)
  }

  deletePost(id: number) {
    return this.http.delete('http://localhost:8080/posts/delete/' + id, httpOptions)
  }

  editPost(post: Post) {
    return this.http.put('http://localhost:8080/posts/edit', post, httpOptions)
  }

}
