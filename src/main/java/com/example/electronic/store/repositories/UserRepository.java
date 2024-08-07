package com.example.electronic.store.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.electronic.store.entity.User;

import jakarta.persistence.Id;

public interface UserRepository extends JpaRepository<User , String>
{
	
	Optional<User> findByEmail(String email);
	
	Optional<User> findByEmailAndPassword(String email,String password);
	
	List<User> findByNameContaining(String keyword);


	

}
