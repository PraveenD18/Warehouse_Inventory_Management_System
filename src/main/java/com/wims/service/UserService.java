package com.wims.service;

import com.wims.dto.request.CreateUserRequest;
import com.wims.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(CreateUserRequest request);

    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long id);

    UserResponse getUserByName(String name);

    UserResponse updateUser(Long id, CreateUserRequest request);

    UserResponse deactivateUser(Long id);

    UserResponse activateUser(Long id);
}
