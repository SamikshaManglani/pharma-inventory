package com.pharma.inventory.service;

import java.util.List;

import com.pharma.inventory.model.Product;

public interface GetMedicineInfo {
	
	public Product getMedicineBasedOnName(String name);
	
	public List<Product> getMedicineBasedOnGenericName(String name);
	
	public List<Product> getMedicineBasedOnCategoryName(String name);

}
