package com.social.controller;

import com.social.entities.Service;
import com.social.entities.User;
import com.social.services.SrvService;
import com.social.services.UserService;
import com.social.util.OnError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("account")
public class AccountController {

	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	private final UserService userService;
	private final SrvService srvService;
    @Autowired
    public AccountController(UserService userService, SrvService srvService) {
        this.userService = userService;
		this.srvService = srvService;
	}

    // request method to create a new account by a guest
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
		return new ResponseEntity<User>(userService.save(newUser), HttpStatus.CREATED);
	}

	// the login api/service
	@CrossOrigin
	@RequestMapping("/login")
	public Principal user(Principal principal) {
		logger.info("user logged "+principal);
		return principal;
	}

	//editing user account data
	@CrossOrigin
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ResponseEntity<?> editUser(@RequestBody User udatedUser) {
		System.out.println(udatedUser.getEmail()+" "+udatedUser.getPassword());
		return new ResponseEntity<User>(userService.updateAll(udatedUser), HttpStatus.CREATED);
	}


	@RequestMapping(value = "/services/{id}", method = RequestMethod.POST)
	public String deleteService(@PathVariable("id") Long id) {
		srvService.delete(id);
		return "deleted "+id;

	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> editServiceUser(@RequestBody User udatedUser,@PathVariable("id")Long id) {
		int prevCost=0;
		int newCost=0;
		if(udatedUser.getScore()<1)
			return new ResponseEntity(
					new OnError("Not enough money to accomplish"),
					HttpStatus.CONFLICT);
    	if(userService.find(udatedUser.getId()).getService()!=null)
   	{
			 prevCost = userService.find(udatedUser.getId()).getService().getCost();
    		 newCost = srvService.find(id).getCost();
    		 if(prevCost>newCost){
    		 	udatedUser.setScore(udatedUser.getScore()-(prevCost-newCost));
    		 	userService.updateAll(userService.updateAll(udatedUser));
			 }
   	}
    	udatedUser.setService(srvService.find(id));
    	return new ResponseEntity<User>(userService.updateAll(udatedUser), HttpStatus.CREATED);
	}

	//editing users password
	@CrossOrigin
	@RequestMapping(value = "/changePas", method = RequestMethod.POST)
	public ResponseEntity<?> editUserPas(@RequestBody User updatedUser) {
		return new ResponseEntity<User>(userService.updatePas(updatedUser), HttpStatus.CREATED);
	}

	@GetMapping(value = "/profile/services")
	public ResponseEntity<?> getAllServices() {
		return new ResponseEntity<List<Service>>(srvService.findAllServices(), HttpStatus.OK);
	}
}
