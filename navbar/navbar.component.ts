import { AuthenticateService } from './../authenticate.service';
import { Component, OnInit } from '@angular/core';
import { Status } from '../model/Status';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(public authService: AuthenticateService, public router: Router) { }

  ngOnInit() {
  }

  signOut() {
    this.authService.signOut()
      .subscribe((res: Status) => {
        if (res.queryStatus) {
          this.authService.loginStatus = false
          this.router.navigateByUrl('/signin')
        }
      })
  }
}
