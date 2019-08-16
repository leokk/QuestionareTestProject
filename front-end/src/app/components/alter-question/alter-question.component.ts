import {Component, Inject, OnInit, ViewEncapsulation} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {Question} from "../../model/model.Question";
import {OverlayContainer} from "@angular/cdk/overlay";

@Component({
  selector: 'app-alter-question',
  templateUrl: './alter-question.component.html',
  styleUrls: ['./alter-question.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class AlterQuestionComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<AlterQuestionComponent>,
              @Inject(MAT_DIALOG_DATA) public data:Question ,overlayContainer: OverlayContainer) {
    this.question=this.data;
    overlayContainer.getContainerElement().classList.add('unicorn-dark-theme');
  }
  question:Question;

  ngOnInit() {
    console.log('question from alter  is');
    console.log(this.question);
  }
  save() {
    this.dialogRef.close(this.question);
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
