package com.wims.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.wims.entity.User;
import com.wims.enums.UserRole;

class UserServiceImplTest {

	@Test
    void user_basic_test() {

        User user = new User();
        user.setId(1L);
        user.setName("Admin");
        user.setEmail("admin@wims.com");
        user.setPassword("password123");
        user.setRole(UserRole.ADMIN);
        user.setActive(true);

        assertNotNull(user);
        assertEquals(1L, user.getId());
        assertEquals("Admin", user.getName());
        assertEquals("admin@wims.com", user.getEmail());
        assertEquals("password123", user.getPassword());
        assertEquals(UserRole.ADMIN, user.getRole());
        assertTrue(user.isActive());
    }

}
