package com.example.demo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class HomeResource {
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
    UserRepository userRepository;
	
	@RequestMapping("/admin")
	public String admin() {
		System.out.println("in admin");
		return "welcome Admin";
	}
	
	@RequestMapping("/")
	public String home() {
		System.out.println("in home");
		return "welcome anyone";
	}
	
	@RequestMapping("/candidate")
	public String candidate() {
		return ("<h1>welcome Candidate</h1>");
	}
	
	@RequestMapping("/hr")
	public String hr() {
		return "welcome HR";
	}
	
	@PostMapping(path="/register" ,consumes = { MediaType.APPLICATION_JSON_VALUE })

	public UserAccount createEmployee(@RequestBody @Valid UserAccount user)
    	{
    	String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
    	System.out.println(encodedPassword);
    	user.setPassword(encodedPassword);
    	System.out.println("POST");
    	
		
		userRepository.save(user);	
		return user;

	}

}
