import {Question} from "./model.Question";

export class Answer {
  id:number;
  type:string;
  input:string;
  label:string;
  active:boolean;
  required:boolean;
}
