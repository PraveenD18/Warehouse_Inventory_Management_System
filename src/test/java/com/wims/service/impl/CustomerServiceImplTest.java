package com.wims.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.wims.entity.Customer;

class CustomerServiceImplTest {
	    @Test
	    void customer_basic_test() {

	        Customer customer = new Customer();
	        customer.setId(1L);
	        customer.setName("John");
	        customer.setPhone("923979223");
	        customer.setActive(true);

	        assertNotNull(customer);
	        assertEquals(1L, customer.getId());
	        assertEquals("John", customer.getName());
	        assertEquals("923979223",customer.getPhone());
	        assertTrue(customer.isActive());
	        assertNotEquals("Alice", customer.getName());
	    }


}
