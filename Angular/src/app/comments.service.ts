import { Comment } from './model/Comment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

const httpOptions = {
  headers: new HttpHeaders({
    'Authorization': 'someToken'
  }),
  withCredentials: true
};

@Injectable({
  providedIn: 'root'
})

export class CommentsService {

  constructor(public http: HttpClient) {

  }

  getComments(postId: number) {
    return this.http.get('http://localhost:8080/postbook/comments/' + postId, httpOptions)
  }

  addComment(comment: Comment) {
    return this.http.post('http://localhost:8080/postbook/comments/save',comment, httpOptions)
  }

  deleteComment(commentId: number) {
    return this.http.delete('http://localhost:8080/postbook/comments/delete/' + commentId, httpOptions)
  }

}
