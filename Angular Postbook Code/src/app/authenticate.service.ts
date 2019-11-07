import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './model/User';
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
export class AuthenticateService {

  loginStatus: boolean
  currentUser: User

  constructor(public http: HttpClient) {
    this.loginStatus = false
  }

  signIn(user: User) {
    return this.http.post('http://localhost:8080/postbook/signin', user, httpOptions)
  }

  signUp(user: User) {
    return this.http.post('http://localhost:8080/postbook/signup', user, httpOptions)
  }

  signOut() {
    return this.http.post('http://localhost:8080/postbook/signout', {}, httpOptions)
  }

}