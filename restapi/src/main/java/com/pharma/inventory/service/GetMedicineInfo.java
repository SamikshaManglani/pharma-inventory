package com.pharma.inventory.service;

import java.util.List;

import com.pharma.inventory.exception.ProductNameNotExistException;
import com.pharma.inventory.exception.ProductWithCategoryNameNotFoundException;
import com.pharma.inventory.exception.ProductWithGenericNameDoesNotExist;
import com.pharma.inventory.model.Product;

public interface GetMedicineInfo {
	
	public Product getMedicineBasedOnName(String name) throws ProductNameNotExistException;
	
	public List<Product> getMedicineBasedOnGenericName(String name) throws ProductWithGenericNameDoesNotExist;
	
	public List<Product> getMedicineBasedOnCategoryName(String name) throws ProductWithCategoryNameNotFoundException;

}
