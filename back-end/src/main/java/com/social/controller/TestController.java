package com.social.controller;

import com.social.entities.Service;
import com.social.services.SrvService;
import com.social.services.UserService;
import com.social.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class TestController {
    private final WorkerService workerService;
    private final UserService userService;
    private final
    SrvService srvService;
    @Autowired
    public TestController(WorkerService workerService, UserService userService, SrvService srvService) {
        this.workerService = workerService;
        this.userService = userService;
        this.srvService = srvService;
    }

    @GetMapping("Test")
    public List<Service> Generate(){
//        Worker w=new Worker(12,"Ali","Baba","+380000000", 3000,"kura");
        //Worker w = workerService.findOne((long)1);
//        User u = new User(1,"2@2","pwd","fname","Lname","+3909090",null,1);
//        User S = userService.find((long) 1);
//        userService.save(u);
     //   w.setFirstName("NEW Fn Name");
//        userService.updateAll(u);
//        workerService.update(w);
//        this.age = age;
//        this.email = email;
//        this.password = password;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.phone = phone;
//        this.service = service;
        return srvService.findAllServices();
    }
}
