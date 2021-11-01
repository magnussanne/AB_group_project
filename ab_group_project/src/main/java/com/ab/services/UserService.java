package com.ab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

	public Users getCurrentUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}

		return userRepository.getUserByUsername(username);
	}
}