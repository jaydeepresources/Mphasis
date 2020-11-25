import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Post } from '../model/post';

const httpOptions = {
  headers: new HttpHeaders({
    'Authorization': 'someToken'
  }),
  withCredentials: true
};

@Injectable({
  providedIn: 'root'
})
export class CrudService {

  posts: Post[]

  constructor(public http: HttpClient) { }

  getPosts() {
    return this.http.get("http://localhost:8080/posts",httpOptions)
  }

  deletePost(id){
    return this.http.delete("http://localhost:8080/posts/delete/" + id,httpOptions)
  }
}