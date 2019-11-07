import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  mobile: string

  constructor(public ar: ActivatedRoute) {
    this.mobile = this.ar.snapshot.paramMap.get('mobile')
  }

  ngOnInit() {
  }

}
