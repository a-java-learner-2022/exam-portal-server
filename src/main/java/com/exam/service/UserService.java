package com.exam.service;

import java.util.List;
import java.util.Set;

import com.exam.model.User;
import com.exam.model.UserRole;

public interface UserService {
	
	//creating user
	public User create(User user, Set<UserRole> userRoles) throws Exception;

	//get user by username
	public User findUserByUsername(String username);
	
	//find all users
	public List<User> findUsers();

	//delete User by username
	public void deleteUserByUsername(String username);

	public User update(User user);



}
