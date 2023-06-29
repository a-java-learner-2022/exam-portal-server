package com.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

	void deleteByUsername(String username);

}
