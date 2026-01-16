package com.wims.service;

import com.wims.entity.Customer;

import java.util.List;

public interface CustomerService {

	Customer createCustomer(Customer customer);

	List<Customer> getAllCustomers();
}
