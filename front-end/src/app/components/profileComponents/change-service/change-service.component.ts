import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import {WorkerService} from "../../../services/worker.service";
import {SrvService} from "../../../services/srv.service";
import {Router} from "@angular/router";
import {AccountService} from "../../../services/account.service";
import {User} from "../../../model/model.user";

@Component({
  selector: 'app-change-service',
  templateUrl: './change-service.component.html',
  styleUrls: ['./change-service.component.css'],
  encapsulation: ViewEncapsulation.None,
  providers: [WorkerService,SrvService]
})
export class ChangeServiceComponent implements OnInit {

  constructor(public router: Router,public srvService: SrvService, public accountService: AccountService) { }
  currentUser = JSON.parse(localStorage.getItem('currentUser'));
  ngOnInit() {
  }

}
