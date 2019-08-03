import {Service} from "./model.srv";

export class User {
  id : number;
  email: string="";
  score: number;
  password: string="";
  firstName: string="";
  lastName: string="";
  age: number;
  phone: string="";
  service:Service;
}
