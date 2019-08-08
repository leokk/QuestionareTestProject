import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {User} from "../../model/model.user";
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";
import {AccountService} from "../../services/account.service";
import {Question} from "../../model/model.Question";
import {FieldService} from "../../services/field.service";
import {Worker} from "../../model/model.worker";

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class QuestionComponent implements OnInit {

  currentUser: User;
  errorMessage:any;
  isSrvButtonClicked:boolean;
  selectedQuestion:Question;
  question:Question = new Question();
  questions:Question[];
  clickedSrv:boolean;
  isSelectedType: any;
  constructor(public authService: AuthService, public router: Router,public fieldService:FieldService,
              public accountService:AccountService) {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
  }

  ngOnInit() {
    this.isSrvButtonClicked=false;
    this.findAllQuestions();
    console.log(this.currentUser);
  }

  // getSrv(){
  //   this.srvService.getCustomerServiceList().subscribe(data=>{
  //     this.srvs=data;
  //     console.log(this.srvs)
  //   },err=>{
  //     console.log(err);
  //     this.errorMessage = "Can`t get Service List";
  //   })
  // }

  findAllQuestions(){
    this.fieldService.findAllQuestions(this.currentUser.id).subscribe(data=>{
      this.questions=data;
      console.log(data);
    },error => {
      console.log(error);
      this.errorMessage = "Can`t get Question List or empty";
    })
  }



  onSelectQuest(quest: Question):void {
    if(this.selectedQuestion==quest)
      this.selectedQuestion=null;
    else
      this.selectedQuestion=quest;
  }
}
