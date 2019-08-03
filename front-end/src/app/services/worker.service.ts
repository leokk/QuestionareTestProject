import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs";
import {AppComponent} from "../app.component";
import {FieldUser} from "../model/model.field-user";
import {Worker} from "../model/model.worker";
import {User} from "../model/model.user";

@Injectable()
export class WorkerService {
  constructor(public http: Http) {
  }

  getWorkerList(): Observable<any> {
    return this.http.get(AppComponent.API_URL + `/account/admin/`).map(response => response.json());
  }
  pushWorkers(workers:Worker[]){
    return this.http.post(AppComponent.API_URL+`/account/admin/`,workers).map(response=>response.json())
  }
  deleteWorker(id:number){
    return this.http.post(AppComponent.API_URL + `/account/admin/${id}`,id).map(response=>response.toString());
  }

}
