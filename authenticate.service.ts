import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './model/User';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticateService {

  loginStatus: boolean

  constructor(public http: HttpClient) {
    this.loginStatus = false
  }

  signIn(user: User) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Authorization': 'someToken'
      }),
      withCredentials: true
    };
    return this.http.post('http://localhost:8080/posts/signin', user, httpOptions)
  }

  signUp(user: User) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Authorization': 'someToken'
      }),
      withCredentials: true
    };
    return this.http.post('http://localhost:8080/posts/signup', user, httpOptions)
  }

  signOut() {
    const httpOptions = {
      headers: new HttpHeaders({
        'Authorization': 'someToken'
      }),
      withCredentials: true
    };
    return this.http.post('http://localhost:8080/posts/signout', {}, httpOptions)
  }

}
