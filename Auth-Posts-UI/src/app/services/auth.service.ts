import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../model/user';

const httpOptions = {
  headers: new HttpHeaders({
    'Authorization': 'someToken'
  }),
  withCredentials: true
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  currentUser: User

  constructor(public http: HttpClient) { }

  signUp(user: User) {
    return this.http.post("http://localhost:8080/signup", user, httpOptions)
  }

  signIn(user: User) {
    return this.http.post("http://localhost:8080/signin", user, httpOptions)
  }

}
