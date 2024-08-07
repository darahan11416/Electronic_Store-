package com.example.electronic.store.service;

import java.util.List;

import com.example.electronic.store.dtos.UserDto;
import com.example.electronic.store.entity.User;

public interface UserService 
{
	//create
	UserDto createUser(UserDto userDto);
	
	
	//update
	
	UserDto updateUser(UserDto userDto, String userId);
	
	
	
	//delete
	Void deleteUser( String userId);
	
	
	//gett all list User
	List<UserDto> getallUser();
	
	
	//get single  user by email
	UserDto getUserByEmail(String email);
	
	//get user by email
	UserDto getUserById(String userId);
	
	//search user 
	List<UserDto> searchUser(String keyword);
	
	
}
