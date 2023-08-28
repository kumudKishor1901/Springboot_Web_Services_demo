package com.rest.webservices.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.rest.webservices.user.User;

@Controller
public class UserDaoServices {
	
	// use JPA Hibernate to connect to database
	// for now we will make a static list of user to work on
	
	
	static Integer count= 0;
	
	static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(++count,"3sha",LocalDate.now().minusYears(30)));
		users.add(new User(++count,"9tara",LocalDate.now().minusYears(45)));
		users.add(new User(++count,"4me",LocalDate.now().minusYears(56)));
	}
	
	public List<User> findAll(){
		return users;
	}
	public User save(User user) {
		user.setId(++count);
		users.add(user);
		return findOne(count);
		
	}
	public User findOne(Integer id) {
		int count = 0;
		for(int i = 0 ; i < users.size();i++) {
			if(users.get(i).getId()== id) {
				count = i;
				break;
			}
		}
		if(count==0) {
			return null;
		}else {
			return users.get(count);
		}
	}
	
	public void deleteById(Integer id) {
		int count = 0;
		for(int i = 0 ; i < users.size();i++) {
			if(users.get(i).getId()== id) {
				count = i;
				break;
			}
		}
		
		users.remove(count);
		count--;
		
	}
	

}
