package com.social.controller;

import com.social.config.EmailCfg;
import com.social.entities.User;
import com.social.services.UserService;
import com.social.util.OnError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@RequestMapping("account")
public class AccountController {
    private EmailCfg emailCfg;
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
    private final UserService userService;

    @Autowired
    public AccountController(UserService userService) {
        this.userService = userService;
    }

    // request method to create a new account
    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        if (userService.find(newUser.getUsername()) != null) {
            logger.error("username Already exist " + newUser.getUsername());
            return new ResponseEntity(
                    new OnError("user with username " + newUser.getUsername() + "already exist "),
                    HttpStatus.CONFLICT);
        }
        newUser.setRole("USER");
        return new ResponseEntity<>(userService.save(newUser), HttpStatus.CREATED);
    }

    // the login api/service
    @CrossOrigin
    @RequestMapping("/login")
    public Principal user(Principal principal) {
        logger.info("user logged " + principal);
        return principal;
    }

    //editing user account data
    @CrossOrigin
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ResponseEntity<?> editUser(@RequestBody User udatedUser) {
        System.out.println(udatedUser.getEmail() + " " + udatedUser.getPassword());
        return new ResponseEntity<>(userService.updateAll(udatedUser), HttpStatus.OK);
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> editServiceUser(@RequestBody User udatedUser, @PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.updateAll(udatedUser), HttpStatus.OK);
    }

    //editing users password
    @CrossOrigin
    @RequestMapping(value = "/changePas", method = RequestMethod.POST)
    public ResponseEntity<?> editUserPas(@RequestBody User updatedUser) {
        return new ResponseEntity<>(userService.updatePas(updatedUser), HttpStatus.OK);
    }

}
