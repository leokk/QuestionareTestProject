import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-refresh-profile',
  templateUrl: './refresh-profile.component.html',
  styleUrls: ['./refresh-profile.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class RefreshProfileComponent implements OnInit {

  constructor(public router: Router) { }

  ngOnInit() {
    this.router.navigate(['/profile']);

  }

}
