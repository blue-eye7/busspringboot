package com.why.BusApp.Service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.why.BusApp.Entity.User.User;
import com.why.BusApp.Repository.user.UserRepo;

@Service
public class UserService {
	
	@Autowired UserRepo userrepo;

	public ResponseEntity<?> signup(User user) {
		if(!userrepo.existsByMobile(user.getMobile())) {
			if(!userrepo.existsByEmail(user.getEmail())) {
				return ResponseEntity.status(HttpStatus.CREATED).body(userrepo.save(user));
			}
			return ResponseEntity.status(HttpStatus.CONFLICT).body("email already exists");
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body("Mobile number already exists");
				
		
	}

	public ResponseEntity<?> login(User user) {
		if(user.getEmail()==null) {
			User u=userrepo.findByMobile(user.getMobile());
			if(u!=null) {
				return user.getPassword().equals(u.getPassword())?ResponseEntity.ok(u):ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("password mismatch");
			}
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("mobile number not found");
		}
		User u=userrepo.findByEmail(user.getEmail());
		if(u!=null) {
			return user.getPassword().equals(u.getPassword())?ResponseEntity.ok(u):ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("password mismatch");
		}
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("email not found");
		
	}
}
