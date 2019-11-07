import { AuthenticateService } from './../authenticate.service';
import { Router, Event, NavigationEnd } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(public router: Router, public authService: AuthenticateService) {
    var sub = router.events.subscribe((event: Event) => {
      if (event instanceof NavigationEnd && !authService.loginStatus) {
        router.navigateByUrl('/signin')
      }
    })
  }

  ngOnInit() {
  }

}
