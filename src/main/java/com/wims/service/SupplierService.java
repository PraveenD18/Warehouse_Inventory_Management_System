package com.wims.service;

import com.wims.entity.Supplier;
import com.wims.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

	private final SupplierRepository supplierRepository;

	public SupplierService(SupplierRepository supplierRepository) {
		this.supplierRepository = supplierRepository;
	}

	public Supplier createSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	public List<Supplier> getAllSuppliers() {
		return supplierRepository.findAll();
	}
}
