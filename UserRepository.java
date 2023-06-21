package com.example.SpringSecurity.repositories;
import org.springframework.data.repository.CrudRepository;

import com.example.SpringSecurity.entities.User;

public interface UserRepository  extends CrudRepository<User, Integer> {
	 public User findByName(String name);

}
