package com.barbecue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private SecurityService securityService;

	@ModelAttribute("user")
	public User getUser() {
		System.out.println("Adding new User");
		return new User();
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping(value="/registerUser", method = RequestMethod.GET)
	public String registrationPage(@ModelAttribute User user) {
		return "registerUser";
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		System.out.println("invoking showRegistration");
		//user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		return "login";
	}

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(required=false, name = "email") String email, @RequestParam(required=false, name = "password") String password) {
		boolean loginResponse = securityService.login(email, password);
		System.out.println("e-mail and password :" + email + "       " + password);
		if (loginResponse) {
			return "home";
		}else {
			System.out.println("Invalid user name or password. Please try again");
		}
		return "login";
	}
	
	//Without Spring Security Service
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
//		User user = userRepository.findByEmail(email);
//		System.out.println("e-mail and password :" + email + "       " + password);
//		if (user.getPassword().equals(password)) {
//			return "home";
//		}else {
//			System.out.println("Invalid user name or password. Please try again");
//		}
//		return "login";
//	}
	
}
