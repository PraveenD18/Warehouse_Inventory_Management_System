package com.wims.service;

import com.wims.entity.User;
import com.wims.enums.UserRole;
import com.wims.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User createUser(User user) {
		if (userRepository.existsByEmail(user.getEmail())) {
			throw new RuntimeException("User already exists");
		}
		return userRepository.save(user);
	}

	public User getUserById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public List<User> getUsersByRole(UserRole role) {
		return userRepository.findByRole(role);
	}

	public User updateUser(Long id, User updatedUser) {
		User user = getUserById(id);
		user.setName(updatedUser.getName());
		user.setRole(updatedUser.getRole());
		user.setActive(updatedUser.isActive());
		return userRepository.save(user);
	}

	public void deactivateUser(Long id) {
		User user = getUserById(id);
		user.setActive(false);
		userRepository.save(user);
	}
}
