package com.wims.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wims.dto.request.CreateSupplierRequest;
import com.wims.dto.response.SupplierResponse;
import com.wims.entity.Supplier;
import com.wims.service.SupplierService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    private final SupplierService supplierService;
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }
    @PostMapping
    public ResponseEntity<SupplierResponse> create(
            @Valid @RequestBody CreateSupplierRequest request) {

        Supplier supplier = new Supplier();
        supplier.setName(request.getName());
        supplier.setContactPhone(request.getContactPhone());

        Supplier saved = supplierService.createSupplier(supplier);
        return new ResponseEntity<>(toResponse(saved), HttpStatus.CREATED);
    }
    @GetMapping
    public List<SupplierResponse> getAll() {
        return supplierService.getAllSuppliers()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private SupplierResponse toResponse(Supplier s) {
        SupplierResponse r = new SupplierResponse();
        r.setId(s.getId());
        r.setName(s.getName());
        r.setContactPhone(s.getContactPhone());
        return r;
    }
}
