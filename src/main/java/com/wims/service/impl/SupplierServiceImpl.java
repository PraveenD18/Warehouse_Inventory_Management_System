package com.wims.service.impl;

import com.wims.entity.Supplier;
import com.wims.repository.SupplierRepository;
import com.wims.service.SupplierService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

	private final SupplierRepository supplierRepository;

	public SupplierServiceImpl(SupplierRepository supplierRepository) {
		this.supplierRepository = supplierRepository;
	}

	@Override
	public Supplier createSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	@Override
	public List<Supplier> getAllSuppliers() {
		return supplierRepository.findAll();
	}
}
