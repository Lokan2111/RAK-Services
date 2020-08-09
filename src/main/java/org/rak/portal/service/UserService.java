package org.rak.portal.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.rak.portal.domain.User;
import org.rak.portal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Optional<User> getUserById(Integer userId) {
		return this.userRepository.findById(userId);
	}
	
	public Optional<User> getUserByMobileNumber(BigInteger mobileNumber) {
		return this.userRepository.findByMobileNumber(mobileNumber);
	}
	
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	public User saveOrUpdate(User user) {
		return this.userRepository.save(user);
	}
}
