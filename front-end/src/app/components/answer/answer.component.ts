import {Component, OnInit, ViewChild, ViewEncapsulation} from '@angular/core';
import {User} from "../../model/model.user";
import {Question} from "../../model/model.Question";
import {MatPaginator, MatTableDataSource} from "@angular/material";
import {FieldService} from "../../services/field.service";
import {OverlayContainer} from "@angular/cdk/overlay";
import {Answer} from "../../model/model.Answer";
import {forEach} from "@angular/router/src/utils/collection";
import {CustomModel} from "../../model/model.CustomModel";

@Component({
  selector: 'app-answer',
  templateUrl: './answer.component.html',
  styleUrls: ['./answer.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class AnswerComponent implements OnInit {

  constructor(public fieldService: FieldService, overlayContainer: OverlayContainer) {
    overlayContainer.getContainerElement().classList.add('unicorn-dark-theme');
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
  }

  @ViewChild(MatPaginator) paginator: MatPaginator;

  currentUser: User;
  errorMessage: any;
  customModel:CustomModel[]=[];

  dataSource = new MatTableDataSource();

  answer: Answer;
  answers: Answer[] = [];

  question: Question;
  questions: Question[];
  displayedColumns: string[] = [];
  clickedSrv: boolean = true;
  str: any;

  ngOnInit() {
    // this.findAllAnswers();
    // this.findAllQuestions();
    console.log("OBJECT FRON SERVER::");
    // console.log(JSON.parse("[{\"Заголовок\":\"[Answer{id=101, input='first answer'}, Answer{id=103, input='answer 2'}]\"},{\"Заголовок2\":\"[Answer{id=102, input='Another answer'}, Answer{id=104, input='Another answer 2'}]\"}]"));
    this.getData();
    //this.findAllQuestions();
    // for (var i = 0, len = q.length; i < len; i++) {
    //   someFn(arr[i]);
    // }
  }


  getData(){
    this.fieldService.getData(this.currentUser.id).subscribe(data => {
      console.log( JSON.stringify( data));
      this.customModel = data;

      this.dataSource.data = data;
      console.log("DATASOURCE: " + this.dataSource.data);
      this.getDisplayedColumns(data);
    },error => {
      console.log(error);
    })
  }

  findAllAnswers() {
    this.fieldService.findAllAnswers(this.currentUser.id).subscribe(data => {
      this.answers = data;
      this.dataSource.data = data;

      this.dataSource.paginator = this.paginator;

      console.log(data);
    }, error => {
      console.log(error);
      this.errorMessage = "Can`t get Response List or empty";
    })
  }

  getDisplayedColumns(data:CustomModel[]) {
    var i=0;
    for (var v in data) {
      for (var k in data[v]) {
        this.displayedColumns.push(k);

        var dataa = k; console.log("k:"+dataa);
        var key = dataa; console.log("key:"+key);
        var objj :any= { [k]: k};
        console.log("obьект :  "+objj[k]);
       // this.dataSource.data.push(objj);
        objj={};
      }

    }
    var unique = this.displayedColumns.filter(function(elem, index, self) {
      return index === self.indexOf(elem);
    });
    this.displayedColumns=unique;
    console.log("DisplayedColumn: " + this.displayedColumns);
    // console.log("DATASOURCE: " + this.dataSource.data);
  }

  renameKeys = (keysMap, obj) =>
    Object.keys(obj).reduce(
      (acc, key) => ({
        ...acc,
        ...{[keysMap[key] || key]: obj[key]}
      }),
      {}
    );

  getAnswers(questions: Question[]) {

    for (var i = 0, len = questions.length; i < len; i++) {
      for (var j = 0, l = questions[i].answer.length; j < l; ++j)
        this.answers.push(questions[i].answer[j])
    }
    this.answers.sort((a, b) => a.id - b.id);
    console.log("Answers: ");
    console.log(this.answers);
  }

  findAllQuestions() {
    this.fieldService.findAllQuestions(this.currentUser.id).subscribe(data => {
      this.questions = data;
      this.getAnswers(data);
      console.log(data);
    }, error => {
      console.log(error);
      this.errorMessage = "Can`t get Question List or empty";
    })
  }
}
