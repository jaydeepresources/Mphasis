import { Post } from './model/Post';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class PostsService {

  public posts: Post[]

  constructor(public http: HttpClient) {
    this.posts = []
  }

  getPosts() {
    return this.http.get('http://localhost:8080/posts/all')
  }

  addPost(post: Post) {
    return this.http.post('http://localhost:8080/posts/add', post)
  }

  deletePost(id: number) {
    return this.http.delete('http://localhost:8080/posts/delete/' + id)
  }
}
