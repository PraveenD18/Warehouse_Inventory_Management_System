package com.wims.dto.request;

import jakarta.validation.constraints.NotBlank;

public class CreateSupplierRequest {

	@NotBlank
	private String name;

	@NotBlank
	private String contactPhone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
}
