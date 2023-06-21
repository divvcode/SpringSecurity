package com.example.SpringSecurity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.SpringSecurity.entities.User;
import com.example.SpringSecurity.repositories.UserRepository;

public class UserService {

	@Autowired
	 private UserRepository userRepository;
	
	

    public Iterable<User> GetAllUsers()
    {
        return userRepository.findAll();
    }


    public User GetUserByName(String name) {
        User foundUser = userRepository.findByName(name);
        return foundUser;
    }
    
    public User GetUserById(int id) throws Exception {
    	Optional<User> foundUser = userRepository.findById(id);
    	
    	//TODO: we need to decide how to handle a "Not Found" condition
    	if(!foundUser.isPresent())
    		return null;
    	
    	return(foundUser.get());
    }
    
    public void UpdateUser(User usertoUpdate) {
    	userRepository.save(usertoUpdate);
    }
    
    public void setUser(User u, String name, String email, String password) {
    	//u.setId(id);
    	u.setName(name);
    	u.setEmail(email);
    	u.setPassword(password);
    	UpdateUser(u);
    }


}
