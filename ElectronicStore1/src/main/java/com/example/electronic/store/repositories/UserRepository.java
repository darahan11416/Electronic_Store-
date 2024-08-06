package com.example.electronic.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.electronic.store.entity.User;

import jakarta.persistence.Id;

public interface UserRepository extends JpaRepository<User , String>
{
	

}
