import {Injectable} from '@angular/core';
import {Http} from "@angular/http";
import {AppComponent} from "../app.component";
import {Observable} from "rxjs";
import {Question} from "../model/model.Question";
import {Answer} from "../model/model.Answer";

@Injectable()
export class FieldService {
  constructor(public http: Http) {
  }

  getFieldList(id: number): Observable<any> {
    return this.http.get(AppComponent.API_URL + `/account/field/${id}`);
  }

  putFieldList(id: number, quest: Question): Observable<any> {
    return this.http.post(AppComponent.API_URL + `/account/field/${id}`, quest);
  }

  deleteFieldList(id: number): Observable<any> {
    return this.http.delete(AppComponent.API_URL + `/account/field/${id}`);
  }

  createQuestion(question: Question, id: number) {
    return this.http.post(AppComponent.API_URL + `/account/field/create/${id}`, question).map(resp => resp.json());
  }

  createResponse(answer: Answer[], id: number) {
    return this.http.post(AppComponent.API_URL + `/account/response/create/${id}`, answer).map(resp => resp.json());
  }

  getData(id: number): Observable<any> {
    return this.http.get(AppComponent.API_URL + `/account/response/${id}`).map(response => response.json());
  }

  findAllQuestions(id: number): Observable<any> {
    return this.http.get(AppComponent.API_URL + `/account/field/${id}`).map(response => response.json());
  }

  findAllAnswers(id: number): Observable<any> {
    return this.http.get(AppComponent.API_URL + `/account/response/${id}`).map(response => response.json());
  }

}
