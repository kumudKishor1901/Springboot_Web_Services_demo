package com.rest.webservices.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.webservices.dao.UserDaoServices;
import com.rest.webservices.exception.UserNotFoundException;
import com.rest.webservices.user.User;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class SocialMediaRestController {
	
	
	private UserDaoServices service ;
	public SocialMediaRestController(UserDaoServices service) {
		this.service = service;
	}
	
	// implementing internationalisation
	
	@GetMapping(value="/goodmorning")
	public String helloWorld() {
		return "Good Morning";
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return service.findAll();
	}
	
	@GetMapping("users/{id}")
	public User findUser(@PathVariable Integer id){
		User user =  service.findOne(id);
		if(user==null) {
			throw new UserNotFoundException("id : "+id);
		}
		else {
			return user;
		}
	}
	
	@DeleteMapping("users/{id}")
	public void DeleteUser(@PathVariable Integer id){
		 service.deleteById(id);
		
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> save(@Valid @RequestBody User user) {
		User newUser = service.save(user);
		//important Learning sending status code and user resource identifier in response
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(newUser.getId())
						.toUri();
		/*ServletUriComponentBuilder is inbuilt spring class having method fromCurrentRequest
		 *  to fetch the current request uri which is "http://localhost:8080/api/users"
		 * here we appended the the id of the current user which is added in list to the uri by using path("id")
		 * and to get the is we used buildAndExpand(object.property) to get the id of the saved user.
		 * now the response uri becomes "http://localhost:8080/api/users/4" 
		 * */
		return ResponseEntity.created(location).build();//through this we are sending the status code and the uri location in response.
	}
	
	
	
	
	
	
	
	
	
}
