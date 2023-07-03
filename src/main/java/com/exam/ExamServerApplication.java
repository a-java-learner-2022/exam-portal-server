package com.exam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamServerApplication implements CommandLineRunner {

//	@Autowired
//	private UserService userService;
//
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ExamServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting code....");

//		try {
//			// creating admin
//			User user = new User();
//			user.setUsername("durga123");
//			user.setPassword(this.bCryptPasswordEncoder.encode("durga123"));
//			user.setFirstname("durga");
//			user.setLastname("maharjan");
//			user.setEmail("dm@gmail.com");
//			user.setPhone(123456789);
//			user.setProfile("defualt.png");
//
//			Role role = new Role();
//			role.setRoleId(44L);
//			role.setRoleName("ADMIN");
//
//			Set<UserRole> userRoleSet = new HashSet<>();
//			UserRole userRole = new UserRole();
//
//			userRole.setRole(role);
//
//			userRole.setUser(user);
//
//			userRoleSet.add(userRole);
//
//			User user1 = this.userService.create(user, userRoleSet);
//			System.out.println(user1);
//		} catch (UserFoundException ex) {
//			throw new UserFoundException();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//
	}

}
