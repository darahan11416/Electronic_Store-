package com.example.electronic.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.electronic.store.dtos.UserDto;
import com.example.electronic.store.service.UserService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	
	
	@PostMapping
	public ResponseEntity<UserDto> createuser(@RequestBody UserDto userDto)
	{
		UserDto user= userService.createUser(userDto);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@PathVariable String userId,@RequestBody UserDto userDto)
	{
		UserDto updatedUser = userService.updateUser(userDto, userId);
		
		return new ResponseEntity<>(updatedUser,HttpStatus.OK);
		
		
	}
	
	
	
	
	
	
	
	

}
