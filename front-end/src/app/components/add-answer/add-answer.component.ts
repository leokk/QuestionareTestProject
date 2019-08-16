import {Component, OnInit, ViewChild, ViewEncapsulation} from '@angular/core';
import {FieldService} from "../../services/field.service";
import {OverlayContainer} from "@angular/cdk/overlay";
import {MatPaginator, MatTableDataSource} from "@angular/material";
import {User} from "../../model/model.user";
import {Question} from "../../model/model.Question";
import {Answer} from "../../model/model.Answer";

@Component({
  selector: 'app-add-answer',
  templateUrl: './add-answer.component.html',
  styleUrls: ['./add-answer.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class AddAnswerComponent implements OnInit {

  constructor(public fieldService:FieldService,overlayContainer: OverlayContainer) {
    overlayContainer.getContainerElement().classList.add('unicorn-dark-theme');
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
  }

  @ViewChild(MatPaginator) paginator: MatPaginator;

  currentUser: User;
  errorMessage:any;
  isSrvButtonClicked:boolean;
  selectedQuestion:Question;
  dataSource = new MatTableDataSource<Answer>();

  answer:Answer;
  answers:Answer[]=[];

  question:Question;
  questions:Question[];
  displayedColumns:string[]= [];
  clickedSrv:boolean = true;
  str:any;

  ngOnInit() {
    this.findAllQuestions();
  }


  prepare(data:Question[]){
    for (var i = 0, len = data.length; i < len; i++) {
      this.answers.push(new Answer());
        console.log(`data[${i}] :`);
        console.log(data[i]);
        //this.answers[i].input="";
      }
    console.log(this.answers);
  }

  initial(data:Question[]){

  }

  findAllQuestions(){
    this.fieldService.findAllQuestions(this.currentUser.id).subscribe(data=>{
      this.questions=data;
      this.questions[0].type='text';
      this.questions[1].type='text';
      this.prepare(data);
    },error => {
      console.log(error);
      this.errorMessage = "Can`t get Question List or empty";
    })
  }

  addAnswer() {
    return false;
  }
}
