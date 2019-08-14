import {Component, Inject, OnInit, ViewEncapsulation} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {Question} from "../../model/model.Question";
import {OverlayContainer} from "@angular/cdk/overlay";
import {FieldService} from "../../services/field.service";
import {User} from "../../model/model.user";

@Component({
  selector: 'app-add-question',
  templateUrl: './add-question.component.html',
  styleUrls: ['./add-question.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class AddQuestionComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<AddQuestionComponent>, public fieldService:FieldService,
               overlayContainer: OverlayContainer) {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    overlayContainer.getContainerElement().classList.add('unicorn-dark-theme');
  }
  question:Question = new Question();
  errorMessage:any;
  currentUser: User;

  ngOnInit() {
    this.question.type='textLine';
  }

  save() {
    this.dialogRef.close(this.question);
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
  addQuestion() {
    this.fieldService.createQuestion(this.question, this.currentUser.id).subscribe(data=>{
      console.log(data);
      this.dialogRef.close(this.question);
      alert("Field Added");
    }, err=>{
      this.errorMessage=err;
    })
  }
}
