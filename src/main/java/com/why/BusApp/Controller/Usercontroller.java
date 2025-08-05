package com.why.BusApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.why.BusApp.Entity.User.User;
import com.why.BusApp.Service.User.UserService;

@RestController
@RequestMapping("/User")
@CrossOrigin(origins = "http://localhost:5173")
public class Usercontroller {
	
	@Autowired UserService userservice;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody User user){
		return userservice.signup(user);
	}
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user){
		System.out.println(user.getMobile());
		return userservice.login(user);
	}
	
}
