package com.wims.repository;

import com.wims.entity.User;
import com.wims.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

	List<User> findByRole(UserRole role);

	boolean existsByEmail(String email);
}
