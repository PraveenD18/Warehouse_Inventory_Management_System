package com.wims.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wims.dto.request.CreateCustomerRequest;
import com.wims.dto.response.CustomerResponse;
import com.wims.entity.Customer;
import com.wims.mapper.CustomerMapper;
import com.wims.repository.CustomerRepository;
import com.wims.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponse createCustomer(CreateCustomerRequest request) {
        Customer customer = customerMapper.toEntity(request);
        return customerMapper.toResponse(customerRepository.save(customer));
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toResponse)
                .toList();
    }

    @Override
    public CustomerResponse getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return customerMapper.toResponse(customer);
    }

    @Override
    public List<CustomerResponse> getCustomerByName(String name) {
        return customerRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(customerMapper::toResponse)
                .toList();
    }

    @Override
    public CustomerResponse updateCustomer(Long id, CreateCustomerRequest request) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customerMapper.updateEntity(customer, request);

        return customerMapper.toResponse(customerRepository.save(customer));
    }
    @Override
    public CustomerResponse activateCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customer.setActive(true);
        return customerMapper.toResponse(customerRepository.save(customer));
    }

    @Override
    public CustomerResponse deactivateCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customer.setActive(false);
        return customerMapper.toResponse(customerRepository.save(customer));
    }

}
