package com.drugstore.drugstore.controllers;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.drugstore.drugstore.models.User;
import com.drugstore.drugstore.repository.UserRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public UserController(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	
 @RequestMapping("/users")
  public @ResponseBody String getUsers() {
    return "{\"users\":[{\"firstname\":\"Richard\", \"lastname\":\"Feynman\"}," +
           "{\"firstname\":\"Marie\",\"lastname\":\"Curie\"}]}";
  }
 
	 @RequestMapping("/")
	 String hello() {
	     return "hello world";
	 }
	 
	@RequestMapping(value="/save-user", method=RequestMethod.POST)
	 public User register(@RequestBody User user) throws NoSuchAlgorithmException {
		 user.setPassword(Helper.getPasswordSalted(user.getPassword()));
		 return  userRepository.save(user);
	 }
	
	@RequestMapping(value="/get-address/{userId}", method=RequestMethod.GET)
	 public User register(@PathVariable String userId) {
		 return  userRepository.findById(userId);
	 }
	
	@RequestMapping(value="/update-user/{userId}", method=RequestMethod.POST)
	 public User update(@RequestBody User user, @PathVariable String userId) {
		System.out.println("Hit");
		 user.setId(userId);
		 User _olduser = userRepository.findById(userId);
		 System.out.println(_olduser.getName());
		 _olduser.setImageName(user.getImageName());
		 _olduser.setImagePath(user.getImagePath());
		 return  userRepository.save(_olduser);	
	 }
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	 public Object login(@RequestBody User user) throws NoSuchAlgorithmException {
		User _user = userRepository.findByEmail(user.getEmail());
		String encryptedPass = Helper.getPasswordSalted(user.getPassword());
		if(_user.getPassword().equals(encryptedPass)) {
			return _user;
		}
		if(_user == null) {
			return false;
		}
		 return false;
	 }
}
