import {Injectable} from '@angular/core';
import {User} from "../model/model.user";
import {Http} from "@angular/http";
import {AppComponent} from "../app.component";

@Injectable()
export class AccountService {
  constructor(public http: Http) {
  }

  createAccount(user: User) {
    return this.http.post(AppComponent.API_URL + '/account/register', user).map(resp => resp.json());
  }

  editAccount(user: User) {
    return this.http.post(AppComponent.API_URL + '/account/edit', user).map(resp => resp.json());
  }
  addDonation(user: User,payment:number) {
    return this.http.post(AppComponent.API_URL + `/account/manager/payment/${payment}`, user).map(resp => resp.json());
  }

  editServiceAccount(user: User, id: number) {
    return this.http.post(AppComponent.API_URL + `/account/edit/${id}`, user).map(resp => resp.json());
  }

  changePass(user: User) {
    return this.http.post(AppComponent.API_URL + '/account/changePas', user).map(resp => resp.json());
  }

  public getDataFromBackend() {
    return this.http.get(AppComponent.API_URL + '/account/Test').map(resp => resp.json())
  }

  public sendData(str: string) {
    return this.http.post(AppComponent.API_URL + '/account/Test', str).map(resp => resp.text())
  }

  public getUserList() {
    return this.http.get(AppComponent.API_URL + `/account/manager/`).map(resp => resp.json());
  }

  getPaymentByUser(id: number) {
    return this.http.get(AppComponent.API_URL + `/account/manager/payment/${id}`).map(resp => resp.json());
  }
}
