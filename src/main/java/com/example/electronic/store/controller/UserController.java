package com.example.electronic.store.controller;

import com.example.electronic.store.dtos.ApiResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.electronic.store.dtos.UserDto;
import com.example.electronic.store.service.UserService;

import java.util.List;


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
		return new ResponseEntity<>(user, HttpStatus.OK);
		
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@PathVariable String userId,@RequestBody UserDto userDto)
	{
		UserDto updatedUser = userService.updateUser(userDto, userId);
		
		return new ResponseEntity<>(updatedUser,HttpStatus.OK);
		
		
	}

	// delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponseMessage> deleteUser(@PathVariable String userId)
	{
		ApiResponseMessage message = ApiResponseMessage.builder().message("user is deleted").success(true).status(HttpStatus.OK).build();
		userService.deleteUser(userId);
		return new ResponseEntity<>(message ,HttpStatus.OK);
	}

	// get all
	@GetMapping("/all")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<UserDto> userDtos = userService.getallUser();
		return new ResponseEntity<>(userDtos, HttpStatus.OK);
	}


	// get by id
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable String userId) {
		UserDto userDto = userService.getUserById(userId);
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}

	//get by email
	@GetMapping("/email/{email}")
	public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email) {
		UserDto userDto = userService.getUserByEmail(email);
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}

	//search user
	@GetMapping("/search/{keyword}")
	public ResponseEntity<List<UserDto>> searchUser(@PathVariable String keyword) {
		List<UserDto> userDtos = userService.searchUser(keyword);
		return new ResponseEntity<>(userDtos, HttpStatus.OK);
	}



	
	
	
	
	
	
	
	

}
