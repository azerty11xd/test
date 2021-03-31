package com.dari.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dari.demo.entities.User;



public interface UserRepo extends JpaRepository<User, Long> {
	

}
