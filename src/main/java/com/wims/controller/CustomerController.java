package com.wims.controller;

import com.wims.dto.request.CreateCustomerRequest;
import com.wims.dto.response.CustomerResponse;
import com.wims.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(
            @RequestBody CreateCustomerRequest request) {
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<CustomerResponse>> getCustomerByName(
            @PathVariable String name) {
        return ResponseEntity.ok(customerService.getCustomerByName(name));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> updateCustomer(
            @PathVariable Long id,
            @RequestBody CreateCustomerRequest request) {
        return ResponseEntity.ok(customerService.updateCustomer(id, request));
    }
    @PutMapping("/{id}/activate")
    public ResponseEntity<CustomerResponse> activateCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.activateCustomer(id));
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<CustomerResponse> deactivateCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.deactivateCustomer(id));
    }

}
