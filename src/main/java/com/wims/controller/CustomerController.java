package com.wims.controller;

import com.wims.dto.request.CreateCustomerRequest;
import com.wims.dto.response.CustomerResponse;
import com.wims.entity.Customer;
import com.wims.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerResponse createCustomer(@Valid @RequestBody CreateCustomerRequest request) {

		Customer customer = new Customer();
		customer.setName(request.getName());
		customer.setPhone(request.getPhone());
		customer.setAddress(request.getAddress());
		customer.setPincode(request.getPincode());

		return map(customerService.createCustomer(customer));
	}

	@GetMapping
	public List<CustomerResponse> getAllCustomers() {
		return customerService.getAllCustomers().stream().map(this::map).collect(Collectors.toList());
	}

	private CustomerResponse map(Customer c) {
		CustomerResponse res = new CustomerResponse();
		res.setId(c.getId());
		res.setName(c.getName());
		res.setPhone(c.getPhone());
		res.setAddress(c.getAddress());
		res.setPincode(c.getPincode());
		return res;
	}
}
