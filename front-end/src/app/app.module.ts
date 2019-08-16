import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/profileComponents/register/register.component';
import { FormsModule } from '@angular/forms';
import { AuthService } from "./services/auth.service";
import {HttpModule} from "@angular/http";
import {AccountService} from "./services/account.service";
import { ProfileComponent } from './components/profileComponents/profile/profile.component';
import {routing} from "./app.routing";
import {FacebookModule} from "ngx-facebook";
import {UrlPermission} from "./urlPermission/url.permission";
import { EditProfileComponent } from './components/profileComponents/edit-profile/edit-profile.component';
import { ChangePassComponent } from './components/profileComponents/change-pass/change-pass.component';
import { RefreshProfileComponent } from './utilities/refresh-profile/refresh-profile.component';
import { AdminComponent } from './components/profileComponents/admin/admin.component';
import { ChangeServiceComponent } from './components/profileComponents/change-service/change-service.component';
import { ManagerComponent } from './components/profileComponents/manager/manager.component';

import {
  DateAdapter, MatButtonModule,
  MatCheckboxModule, MatDatepickerModule,
  MatDialogModule, MatFormFieldModule, MatInputModule, MatNativeDateModule,
  MatPaginatorModule,
  MatTableModule
} from "@angular/material";
import { AnswerComponent } from './components/answer/answer.component';
import { QuestionComponent } from './components/question/question.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {FieldService} from "./services/field.service";
import { AlterQuestionComponent } from './components/alter-question/alter-question.component';
import { AddQuestionComponent } from './components/add-question/add-question.component';
import { AddAnswerComponent } from './components/add-answer/add-answer.component';






@NgModule({
  declarations: [

    AppComponent,
    LoginComponent,
    RegisterComponent,
    ProfileComponent,
    EditProfileComponent,
    ChangePassComponent,
    RefreshProfileComponent,
    AdminComponent,
    ChangeServiceComponent,
    ManagerComponent,
    AnswerComponent,
    QuestionComponent,
    AlterQuestionComponent,
    AddQuestionComponent,
    AddAnswerComponent,

  ],
  imports: [
    BrowserModule, HttpModule, FormsModule, routing, FacebookModule.forRoot(),
    MatDialogModule, MatButtonModule, MatCheckboxModule, BrowserAnimationsModule, MatTableModule,
    MatPaginatorModule, MatFormFieldModule, MatInputModule, MatDatepickerModule,
    MatNativeDateModule
  ],
  entryComponents:[ AnswerComponent,
    QuestionComponent,AlterQuestionComponent,AddQuestionComponent],
  providers: [AuthService,AccountService,UrlPermission,FieldService, MatDatepickerModule,  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
