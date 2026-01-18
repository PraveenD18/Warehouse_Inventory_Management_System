package com.wims.mapper;

import com.wims.dto.request.CreateCustomerRequest;
import com.wims.dto.response.CustomerResponse;
import com.wims.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toEntity(CreateCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setPhone(request.getPhone());
        customer.setAddress(request.getAddress());
        customer.setPincode(request.getPincode());
        return customer;
    }

    public void updateEntity(Customer customer, CreateCustomerRequest request) {
        customer.setName(request.getName());
        customer.setPhone(request.getPhone());
        customer.setAddress(request.getAddress());
        customer.setPincode(request.getPincode());
    }

    public CustomerResponse toResponse(Customer customer) {
        CustomerResponse response = new CustomerResponse();
        response.setId(customer.getId());
        response.setName(customer.getName());
        response.setPhone(customer.getPhone());
        response.setAddress(customer.getAddress());
        response.setPincode(customer.getPincode());
        response.setActive(customer.isActive());
        return response;
    }
}

