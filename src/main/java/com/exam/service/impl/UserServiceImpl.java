package com.exam.service.impl;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.RoleRepository;
import com.exam.dao.UserRepository;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;
import com.exam.util.UserFoundException;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	//creating user 
	@Override
	public User create(User user, Set<UserRole> userRoles) throws Exception {
		User local = this.userRepository.findByUsername(user.getUsername());
		if (local!=null) {
			throw new UserFoundException();
		}else {
			//create user
			for (UserRole ur:userRoles) {
				this.roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
		}
		return local;
	}

	@Override
	public User findUserByUsername(String username) {
		return this.userRepository.findByUsername(username);
	}
	
	@Override
	public List<User> findUsers() {
		return this.userRepository.findAll();
	}

	@Transactional
	@Override
	public void deleteUserByUsername(String username) {
		this.userRepository.deleteByUsername(username);
	}

	@Override
	public User update(User user) {
	  return this.userRepository.save(user);
	
	}



}
