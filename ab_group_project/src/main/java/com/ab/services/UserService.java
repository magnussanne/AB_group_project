package com.ab.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ab.entities.Users;
import com.ab.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public Users checkUser(String username, String password) {
		return userRepository.loginCheck(username, password);
	}
}