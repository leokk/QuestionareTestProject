import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs";
import {AppComponent} from "../app.component";
import {Service} from "../model/model.srv";

@Injectable()
export class SrvService {
  constructor(public http: Http) {
  }

  getServiceList(): Observable<any> {
    return this.http.get(AppComponent.API_URL + `/account/admin/services/`).map(response => response.json());
  }
  pushServices(srv:Service[]){
    return this.http.post(AppComponent.API_URL+`/account/admin/services/`,srv).map(response=>response.json())
  }
  deleteService(id:number){
    return this.http.post(AppComponent.API_URL + `/account/admin/services/${id}`,id).map(response=>response.toString());
  }
  getCustomerServiceList(): Observable<any> {
    return this.http.get(AppComponent.API_URL + `/account/profile/services/`).map(response => response.json());
  }
}
