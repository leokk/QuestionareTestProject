package com.social.controller;

import com.social.entities.Service;
import com.social.entities.Worker;
import com.social.services.SrvService;
import com.social.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account/admin")
public class AdminController {

    private final
    WorkerService workerService;
    private final
    SrvService srvService;

    @Autowired
    public AdminController(WorkerService workerService, SrvService srvService) {
        this.workerService = workerService;
        this.srvService = srvService;
    }


    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createWorker(@RequestBody List<Worker> newWorker) {
        System.out.println(newWorker.toString());
        return new ResponseEntity<List<Worker>>(workerService.updateAll(newWorker),HttpStatus.CREATED);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST,value = "/services/")
    public ResponseEntity<?> createServiceS(@RequestBody List<Service> newWorker) {
        System.out.println(newWorker.toString());
        return new ResponseEntity<List<Service>>(srvService.updateAll(newWorker),HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String deleteWorker(@PathVariable("id") Long id) {
        workerService.delete(id);
        return "deleted "+id;

    }
    @RequestMapping(value = "/services/{id}", method = RequestMethod.POST)
    public String deleteService(@PathVariable("id") Long id) {
        srvService.delete(id);
        return "deleted "+id;

    }

    @GetMapping(value = "/services")
    public ResponseEntity<?> getAllServices() {
        return new ResponseEntity<List<Service>>(srvService.findAllServices(), HttpStatus.OK);
    }

    @GetMapping
   // public String GetSmth(@RequestParam String oldPas,@RequestParam String newPas,@RequestParam String retypePas){
		public List<Worker> getWorkers(){
        return workerService.findAllWorkers();
	}


}
