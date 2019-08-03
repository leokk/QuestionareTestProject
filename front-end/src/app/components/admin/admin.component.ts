import {Component, Injectable, OnInit, ViewEncapsulation} from '@angular/core';
import {Worker} from "../../model/model.worker";
import {WorkerService} from "../../services/worker.service";
import {Router} from "@angular/router";
import {SrvService} from "../../services/srv.service";
import {Service} from "../../model/model.srv";

@Injectable()
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
  encapsulation: ViewEncapsulation.None,
  providers: [WorkerService,SrvService]
})
export class AdminComponent implements OnInit {


  constructor(public workerService: WorkerService,public router: Router,public srvService: SrvService) { }
  selectedWorker:Worker;
  selectedSrv:Service;
  newSrv:Service = new Service();
  srvs:Service[];
  errorMessage:any;
  newWorker:Worker=new Worker();
  workers:Worker[];
  clickedWorker:boolean;
  clickedSrv:boolean;

  addToArrayWorkers(){
    this.workers.push(this.newWorker);
    console.log(this.workers);
    this.pushWorkers();
  }

  addToArrayServices(){
    this.srvs.push(this.newSrv);
    console.log(this.newSrv);
    this.pushServices();
  }

  ngOnInit() {
    this.getWorker();
    this.getSrv();
    this.clickedWorker = false;
    this.clickedSrv = false;
  }

  addWorkerClick(){
    this.clickedWorker=!this.clickedWorker;
  }
  addSrvClick(){
    this.clickedSrv=!this.clickedSrv;
  }

  onSelectWorker(worker: Worker): void {
    if(this.selectedWorker==worker)
      this.selectedWorker=null;
    else
      this.selectedWorker = worker;
  }

  onSelectSrv(srv: Service): void {
    if(this.selectedSrv==srv)
      this.selectedSrv=null;
    else
      this.selectedSrv = srv;
  }

  getWorker(){
    this.workerService.getWorkerList().subscribe(data=>{
      this.workers=data;
      console.log(this.workers)
    },err=>{
      console.log(err);
      this.errorMessage = "Can`t get Worker List";
    })
  }
  getSrv(){
    this.srvService.getServiceList().subscribe(data=>{
      this.srvs=data;
      console.log(this.srvs)
    },err=>{
      console.log(err);
      this.errorMessage = "Can`t get Service List";
    })
  }

  pushWorkers(){
    this.workerService.pushWorkers(this.workers).subscribe(data=>{
      this.router.navigate([`/admin`]);
    },err=>{
      console.log(err);
      this.errorMessage = "something wrong";
    })
  }

  pushServices(){
    this.srvService.pushServices(this.srvs).subscribe(data=>{
      this.router.navigate([`/admin`]);
    },err=>{
      console.log(err);
      this.errorMessage = "something wrong";
    })
  }

  deleteWorker(){
    this.workerService.deleteWorker(this.selectedWorker.id).subscribe(data=>{
      this.router.navigate(['/admin?refresh=1']);
    }, err=>{
      this.errorMessage="can`t delete";
    })
  }

  deleteService(){
    this.srvService.deleteService(this.selectedSrv.id).subscribe(data=>{
      this.router.navigate(['/admin?refresh=1']);
    }, err=>{
      this.errorMessage="can`t delete";
    })
  }

}
