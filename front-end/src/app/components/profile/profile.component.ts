import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {User} from "../../model/model.user";
import {Router} from "@angular/router";
import {WorkerService} from "../../services/worker.service";
import {SrvService} from "../../services/srv.service";
import {AccountService} from "../../services/account.service";
import {Service} from "../../model/model.srv";
import {MatDialog} from "@angular/material";
import {QuestionComponent} from "../question/question.component";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
  encapsulation: ViewEncapsulation.None,
  providers: [WorkerService,SrvService]
})
export class ProfileComponent implements OnInit {
  currentUser: User;
  errorMessage:any;
  isSrvButtonClicked:boolean;
  selectedSrv:Service;
  srvs:Service[];
  clickedSrv:boolean;
  constructor(public dialog: MatDialog, public authService: AuthService, public router: Router, public srvService:SrvService,
              public accountService:AccountService) {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
  }

  ngOnInit() {
    this.isSrvButtonClicked=false;
    this.getSrv();
    console.log(this.currentUser);
  }

  addSrvClick(){
    this.isSrvButtonClicked=!this.isSrvButtonClicked;

    console.log(this.currentUser);
  }

  // openDialog(): void {
  //   const dialogRef = this.dialog.open(QuestionComponent, {
  //
  //     panelClass: 'my-centered-dialog',
  //     width: '512px'
  //
  //     // data: {name: this.name, animal: this.animal}
  //   });
  //
  //   dialogRef.afterClosed().subscribe(result => {
  //     console.log('The dialog was closed');
  //     // this.animal = result;
  //   });
  // }

  onSelectSrv(srv: Service): void {
    if(this.selectedSrv==srv)
      this.selectedSrv=null;
    else
      this.selectedSrv = srv;
  }

  getSrv(){
    this.srvService.getCustomerServiceList().subscribe(data=>{
      this.srvs=data;
      console.log(this.srvs)
    },err=>{
      console.log(err);
      this.errorMessage = "Can`t get Service List";
    })
  }


// login out from the app
  logOut() {
    this.authService.logOut()
      .subscribe(
        data => {
          this.router.navigate(['/login']);
        },
        error => {

        });
  }
  changeUserService(){

    this.accountService.editServiceAccount(this.currentUser,this.selectedSrv.id).subscribe(data=>{
      console.log(data);
      localStorage.setItem('currentUser',JSON.stringify(data));
      this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    },err=>{
      this.errorMessage=err;
    })
  }
}
