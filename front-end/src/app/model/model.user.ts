import {Service} from "./model.srv";
import {Question} from "./model.Question";
import {Answer} from "./model.Answer";

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
  questions:Question[];
  answers:Answer[];
}
