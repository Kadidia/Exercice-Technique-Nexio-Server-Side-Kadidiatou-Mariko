package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.model.UserAuthentification;
import com.example.demo.repository.UserRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
	
	@Autowired
	UserRepo userRepo;

	@RequestMapping(value="/user/authentification", method=RequestMethod.POST)
	public ResponseEntity<Boolean>  isUserExist(@RequestBody UserAuthentification userAuth) {
		Boolean isUserExist = false;
		try {
			ArrayList<User> users =  (ArrayList<User>) userRepo.findAll();
			for(User user : users) {
				if(user.getLogin().equals(userAuth.getLogin()) && 
						user.getPassword().equals(userAuth.getPassword())) isUserExist = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Boolean>(isUserExist, HttpStatus.OK);
	}
}
