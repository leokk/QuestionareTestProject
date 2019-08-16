import {Injectable} from '@angular/core';
import {Http} from "@angular/http";
import {AppComponent} from "../app.component";
import {Observable} from "rxjs";
import {FieldUser} from "../model/model.field-user";
import {Question} from "../model/model.Question";
import {User} from "../model/model.user";

@Injectable()
export class FieldService {
  constructor(public http: Http) { }

  getFieldList(id:number):Observable<any> {
    return this.http.get(AppComponent.API_URL+`/account/field/${id}`);
  }

  createQuestion(question:Question,id:number){
    return this.http.post(AppComponent.API_URL+`/account/field/create/${id}`,question).map(resp=>resp.json());
  }

  findAllQuestions(id:number): Observable<any> {
    return this.http.get(AppComponent.API_URL + `/account/field/${id}`).map(response => response.json());
  }
  findAllAnswers(id:number): Observable<any> {
    return this.http.get(AppComponent.API_URL + `/account/response/${id}`).map(response => response.json());
  }
  //Todo: change with FieldUser

  createField(fieldUser:FieldUser){
    return this.http.post(AppComponent.API_URL+'/account/field/create',fieldUser).map(resp=>resp.json());
  }

  editField(fieldUser:FieldUser){
    return this.http.post(AppComponent.API_URL+'/account/field',fieldUser).map(resp=>resp.json());
  }

  removeField(fieldUser:FieldUser){
    return this.http.post(AppComponent.API_URL+'/account/field/delete',fieldUser).map(resp=>resp.json());
  }

}
