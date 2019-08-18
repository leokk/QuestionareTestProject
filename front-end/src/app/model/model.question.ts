import {Answer} from "./model.Answer";
import {User} from "./model.user";

export class Question {
  id:number;
  type:string;
  input:string;
  label:string;
  active:boolean;
  required:boolean;
  answer:Answer[];
  user:User;
}
