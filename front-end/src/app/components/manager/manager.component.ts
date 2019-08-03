import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import {User} from "../../model/model.user";
import {AccountService} from "../../services/account.service";
import {Router} from "@angular/router";
import {Observable} from "rxjs";
import {Payment} from "../../model/model.payments";

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ManagerComponent implements OnInit {
  currentUser: User = new User();
  currentMoney: number;
  errorMessage:any;
  userList: User[];
  user:User = new User();
  objValue: any;
  private num: number;
  userPayments:Payment[];
  allPayments:Payment[];
  constructor(public router: Router, public accountService: AccountService) {
  }

  ngOnInit() {
    this.getUserList();

  }


  getUserList(){
    this.accountService.getUserList().subscribe(data=>{
      this.userList=data;
      this.currentUser =this.userList[0];
      console.log(this.userList)
    },err=>{
      console.log(err);
      this.errorMessage = "Can`t get User List";
    })
  }

  getSelectedUser(id:string) {
    this.currentUser = JSON.parse(id);
    console.log(this.currentUser.id);
  }

  stringify(obj:any){
    return JSON.stringify(obj);
  }


  addDonation() {
   this.accountService.addDonation(this.currentUser,this.currentMoney).subscribe(data=>{
     console.log(data);
     alert("donated "+this.currentMoney);
   }, err=>{
     this.errorMessage=err;
   })
  }

  getPayments() {
    console.log(this.currentUser.id);
    this.accountService.getPaymentByUser(this.currentUser.id).subscribe(data=>{
      console.log(data);
      this.userPayments=data;
    },err=>{
      this.errorMessage=err;
    })
  }
}
