import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {User} from "../../model/model.user";

@Component({
  selector: 'app-congratulations-page',
  templateUrl: './congratulations-page.component.html',
  styleUrls: ['./congratulations-page.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class CongratulationsPageComponent implements OnInit {

  constructor() {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
  }

  currentUser: User;
  errorMessage: any;

  ngOnInit(): void {
  }

}
