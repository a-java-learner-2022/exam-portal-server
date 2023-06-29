package com.exam.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//creating user
	@PostMapping("/create")
	public User create(@RequestBody User user) throws Exception {
		
		user.setProfile("default.png");
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		
		Role normal = new Role();
		normal.setRoleId(45L);
		normal.setRoleName("NORMAL"); //role done
		
//		Role admin = new Role();
//		admin.setRoleId(44L);
//		admin.setRoleName("ADMIN");
		
		//setting NORMAL role for user
		UserRole userNormal = new UserRole();
		userNormal.setRole(normal);
		userNormal.setUser(user);
		
		//setting ADMIN role for user
//		UserRole userAdmin = new UserRole();
//		userAdmin.setRole(admin);
//		userAdmin.setUser(user);
		
		Set<UserRole> userRoleSet = new HashSet<>();
		userRoleSet.add(userNormal);
//		userRoleSet.add(userAdmin);
		
		System.out.println(user.toString());
		
		return this.userService.create(user,userRoleSet);
	}
	
	
	@GetMapping("/{username}")
	 public User findUserByUsername(@PathVariable("username") String username) {
		return this.userService.findUserByUsername(username);
	}
	
	@GetMapping("/")
	public List<User> findUsers(){
		return this.userService.findUsers();
	}
	
	@DeleteMapping("/{username}")
	public void deleteUserbyUsername(@PathVariable("username") String username) {
		this.userService.deleteUserByUsername(username);
	}
	
	
	@PutMapping("/")
	public User update(@RequestBody User user) throws Exception {
	 return this.userService.update(user);
	}
	
//	@ExceptionHandler(UserFoundException.class)
//	public ResponseEntity<?> exceptionHandler(UserFoundException ex){
//		return ResponseEntity<T>
//	}

}
