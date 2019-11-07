import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class PostsService {

  constructor(public http: HttpClient) { 

  }

  getPosts(){
    return this.http.get('http://localhost:8080/posts/all')
  }

}
