import {Component, NgModule, OnInit, ViewEncapsulation} from '@angular/core';
import {User} from "../../model/model.user";
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";
import {AccountService} from "../../services/account.service";
import {Question} from "../../model/model.Question";
import {FieldService} from "../../services/field.service";
import {MatTableDataSource, MatTableModule} from "@angular/material";
import { CdkTableModule } from "@angular/cdk/table";

@NgModule({
  imports: [
    CdkTableModule,
    MatTableModule,
  ]
})

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
  dataSource = new MatTableDataSource<Question>();
  question:Question = new Question();
  questions:Question[];
  displayedColumns = ['label', 'type', 'required','isActive','actions'];
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



  findAllQuestions(){
    this.fieldService.findAllQuestions(this.currentUser.id).subscribe(data=>{
      this.questions=data;
      this.dataSource=data;
      // this.questions.sort((a, b) => a.id-b.id);
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

  deleteRow(j: number) {
    if (j > -1) {
      this.questions.splice(j, 1);
      this.dataSource = new MatTableDataSource<Question>(this.questions);
      console.log(this.questions);
    }
  }
}
