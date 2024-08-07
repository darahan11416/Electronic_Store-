package com.example.electronic.store.service_impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.electronic.store.dtos.UserDto;
import com.example.electronic.store.entity.User;
import com.example.electronic.store.repositories.UserRepository;
import com.example.electronic.store.service.UserService;

@Service
public class UserServiceImpl implements UserService 
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		
		//generate uniq id in string
		String userId = UUID.randomUUID().toString();
		userDto.setUserId(userId);
		
		User user = dtoToEntity(userDto);
		User savedUser = userRepository.save(user);
		
		UserDto newDto = entityToDto(savedUser);
		
		
		
		
		return newDto;
	}

	

	@Override
	public UserDto updateUser(UserDto userDto, String userId) {
		
	User user =	userRepository.findById(userId)
		.orElseThrow(()-> new RuntimeException("User not found exception"));
		
		user.setName(userDto.getName());
		user.setAbout(userDto.getAbout());
		user.setGender(userDto.getGender());
		user.setPassword(userDto.getPassword());
		
		//save
		
	 User updatedUser=	userRepository.save(user);
		UserDto updatedDto = entityToDto(updatedUser);
		
		
		
		return updatedDto;
	}

	@Override
	public Void deleteUser(String userId) {
		
		User user =	userRepository.findById(userId)
				.orElseThrow(()-> new RuntimeException("User not found exception"));
		
		//delete
		userRepository.delete(user);
		
		
		
		return null;
	}

	@Override
	public List<UserDto> getallUser() {
		
		List<User> users = userRepository.findAll();
		
		List<UserDto> dtolist =  users.stream().map(user -> entityToDto(user)).collect(Collectors.toList());

		return dtolist ;
	}

	@Override
	public UserDto getUserByEmail(String email) {
		
	User user = 	userRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("Email not found"));
		
		return entityToDto(user);
	}

	@Override
	public UserDto getUserById(String userId) {
		User user =	userRepository.findById(userId)
				.orElseThrow(()-> new RuntimeException("User not found exception"));
		
		
		return entityToDto(user);
	}

	@Override
	public List<UserDto> searchUser(String keyword) {
	
		List<User> users = userRepository.findByNameContaining(keyword);
		List<UserDto> dtolist = users.stream().map(user -> entityToDto(user)).collect(Collectors.toList());
		
		
		return dtolist;
	}
	
	
	// update only email
	public UserDto updateUserEmail(String email, String userId) {
        
        User user =	userRepository.findById(userId)
        		                .orElseThrow(()-> new RuntimeException("User not found exception"));
        
        user.setEmail(email);
        return entityToDto(userRepository.save(user));
	}
	
	private UserDto entityToDto(User savedUser) {
		// TODO Auto-generated method stub
//		UserDto userDto = UserDto.builder()
//			.userId(savedUser.getUserId())
//			.name(savedUser.getName())
//			.email(savedUser.getEmail())
//			.password(savedUser.getPassword())
//			.about(savedUser.getAbout())
//			.gender(savedUser.getGender())
//			.imageName(savedUser.getImageName()).build();
		
		
		return mapper.map(savedUser, UserDto.class);
	}

	private User dtoToEntity(UserDto userDto) {
		
//		User user= User.builder()
//				.userId(userDto.getUserId())
//				.name(userDto.getName())
//				.email(userDto.getEmail())
//				.password(userDto.getPassword())
//				.about(userDto.getAbout())
//				.gender(userDto.getGender())
//				.imageName(userDto.getImageName())
//				.build();
		// TODO Auto-generated method stub
		return mapper.map(userDto, User.class);
	}
	
	

}
