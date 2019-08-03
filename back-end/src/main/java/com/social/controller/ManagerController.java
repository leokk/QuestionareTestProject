package com.social.controller;

import com.social.entities.Payment;
import com.social.entities.User;
import com.social.services.PaymentService;
import com.social.services.SrvService;
import com.social.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("account/manager")
public class ManagerController {
    private final
    UserService userService;
    private final
    SrvService srvService;
    private final
    PaymentService paymentService;

    @Autowired
    public ManagerController(UserService userService, SrvService srvService, PaymentService paymentService) {
        this.userService = userService;
        this.srvService = srvService;
        this.paymentService = paymentService;
    }

    //editing users password
    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "payment/{sum}")

    public ResponseEntity<?> addPayment(@RequestBody User user, @PathVariable("sum") int sum) {
        User u = userService.find(user.getId());
        paymentService.save(new Payment(sum, u));
        u.setScore(u.getScore() + sum);
        System.out.println("new Sum" + u.getScore());
        return new ResponseEntity<>(userService.updateAll(u), HttpStatus.OK);
    }

    @RequestMapping(value = "payment/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPaymentsByUser(@PathVariable("id") Long id) {
        return new ResponseEntity<>(paymentService.getAllPaymentsByUser(userService.find(id)), HttpStatus.OK);
    }

    @GetMapping(value = "payment")
    public ResponseEntity<?> getAllPayments(@RequestBody User user) {
        return new ResponseEntity<>(paymentService.getAllPaymentsByUser(user), HttpStatus.OK);
    }
}
