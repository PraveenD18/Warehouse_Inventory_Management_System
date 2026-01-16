package com.wims.service;

import com.wims.entity.User;
import com.wims.enums.UserRole;

import java.util.List;

public interface UserService {

	User createUser(User user);

	User getUserById(Long id);

	List<User> getAllUsers();

	List<User> getUsersByRole(UserRole role);

	User updateUser(Long id, User updatedUser);

	void deactivateUser(Long id);
}
