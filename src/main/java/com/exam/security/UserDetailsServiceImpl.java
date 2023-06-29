package com.exam.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exam.dao.UserRepository;
import com.exam.model.User;

@Service
public class UserDetailsServiceImpl implements  UserDetailsService{


	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =  this.userRepository.findByUsername(username);
		
		if (user==null) {
			throw new UsernameNotFoundException("No user found");
		}
		return user;
	}

}
