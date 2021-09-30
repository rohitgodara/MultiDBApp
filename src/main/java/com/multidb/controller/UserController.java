package com.multidb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multidb.form.RegisterationForm;
import com.multidb.service.UserService;
import com.multidb.user.entity.User;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody RegisterationForm form){
		User user = service.save(form);
		return ResponseEntity.ok(user);
	}
}
