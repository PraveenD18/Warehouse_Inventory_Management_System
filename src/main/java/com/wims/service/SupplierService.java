package com.wims.service;

import com.wims.entity.Supplier;

import java.util.List;

public interface SupplierService {

	Supplier createSupplier(Supplier supplier);

	List<Supplier> getAllSuppliers();
}
