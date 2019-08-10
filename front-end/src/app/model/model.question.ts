import {Answer} from "./model.Answer";

export class Question {
  id:number;
  type:string;
  input:string;
  label:string;
  active:boolean;
  required:boolean;
  answer:Answer
}
