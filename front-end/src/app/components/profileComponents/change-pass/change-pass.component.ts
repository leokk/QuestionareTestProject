import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AppComponent} from "../../../app.component";
import {Http} from "@angular/http";
import {AccountService} from "../../../services/account.service";
import {User} from "../../../model/model.user";
import {Router} from "@angular/router";
import {Pass} from "../../../model/model.pass";

@Component({
  selector: 'app-change-pass',
  templateUrl: './change-pass.component.html',
  styleUrls: ['./change-pass.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ChangePassComponent implements OnInit {
  oldPass:string;
  newPas: string;
  retypePas: string;
  user: User = new User();
  oldUs:User;
  errorMessage: string;
  pass:Pass = new Pass();

  constructor(public accountService: AccountService, public router: Router) {
    this.oldUs = JSON.parse(localStorage.getItem('currentUser'));
  }


  ngOnInit() {
    this.oldUs =JSON.parse(localStorage.getItem('currentUser'));
    console.log("Пароли "+this.pass.oldPas + " "+localStorage.getItem('currentPas'));
  }
  equals(){
    // console.log("Пароли "+this.pass.oldPas + " "+localStorage.getItem('currentPas'));
    return this.newPas===this.retypePas;
  }
  changePas() {
    this.user.id=this.oldUs.id;
  //  console.log("current user : " + JSON.stringify(this.oldUs));
    this.user.password=this.pass.newPas;

    if(this.pass.oldPas==localStorage.getItem('currentPas')){

      this.accountService.changePass(this.user).subscribe(data => {
          localStorage.setItem('currentPas',this.pass.newPas);
          this.router.navigate(['/profile']);
        }, err => {
          console.log(err);
          this.errorMessage = "Bad parameters";
        }
      )
    }
    else{
      this.errorMessage = "Old Pas is not valid";
    }

  }
}
