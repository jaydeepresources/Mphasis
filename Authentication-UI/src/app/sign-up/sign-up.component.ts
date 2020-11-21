import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  user: User
  successFlag: boolean
  errorFlag: boolean
  progressFlag: boolean

  constructor(public auth: AuthService) {
    this.user = new User()
  }

  ngOnInit(): void {
  }

  signUpSubmit(signUpForm) {
    this.progressFlag = true
    this.successFlag = false
    this.errorFlag = false

    this.auth.signUp(this.user).subscribe(dbUser => {

      if (dbUser === null) {
        this.errorFlag = true
      }

      else {
        this.successFlag = true
      }

      this.progressFlag = false
    })

    this.user = new User()
    signUpForm.form.markAsPristine()
  }

}
