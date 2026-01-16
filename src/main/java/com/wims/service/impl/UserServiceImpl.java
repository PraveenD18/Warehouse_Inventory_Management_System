package com.wims.service.impl;

import com.wims.entity.User;
import com.wims.enums.UserRole;
import com.wims.repository.UserRepository;
import com.wims.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User createUser(User user) {
		if (userRepository.existsByEmail(user.getEmail())) {
			throw new RuntimeException("User already exists");
		}
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public List<User> getUsersByRole(UserRole role) {
		return userRepository.findByRole(role);
	}

	@Override
	public User updateUser(Long id, User updatedUser) {
		User user = getUserById(id);
		user.setName(updatedUser.getName());
		user.setRole(updatedUser.getRole());
		user.setActive(updatedUser.isActive());
		return userRepository.save(user);
	}

	@Override
	public void deactivateUser(Long id) {
		User user = getUserById(id);
		user.setActive(false);
		userRepository.save(user);
	}
}
