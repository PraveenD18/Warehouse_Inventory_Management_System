package com.wims.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wims.dto.request.CreateUserRequest;
import com.wims.dto.response.UserResponse;
import com.wims.entity.User;
import com.wims.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {

		User user = new User();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setRole(request.getRole());

		User saved = userService.createUser(user);
		return new ResponseEntity<>(mapToResponse(saved), HttpStatus.CREATED);
	}

	@GetMapping
	public List<UserResponse> getAllUsers() {
		return userService.getAllUsers().stream().map(this::mapToResponse).collect(Collectors.toList());
	}

	private UserResponse mapToResponse(User user) {
		UserResponse res = new UserResponse();
		res.setId(user.getId());
		res.setName(user.getName());
		res.setEmail(user.getEmail());
		res.setRole(user.getRole());
		res.setActive(user.isActive());
		return res;
	}
}
