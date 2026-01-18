package com.wims.service;

import com.wims.dto.request.CreateCustomerRequest;
import com.wims.dto.response.CustomerResponse;

import java.util.List;

public interface CustomerService {

    CustomerResponse createCustomer(CreateCustomerRequest request);

    List<CustomerResponse> getAllCustomers();

    CustomerResponse getCustomerById(Long id);

    List<CustomerResponse> getCustomerByName(String name);

    CustomerResponse updateCustomer(Long id, CreateCustomerRequest request);
    
    CustomerResponse activateCustomer(Long id);

    CustomerResponse deactivateCustomer(Long id);

}
