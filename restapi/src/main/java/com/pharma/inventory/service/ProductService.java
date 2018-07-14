package com.pharma.inventory.service;

import java.util.List;

import com.pharma.inventory.exception.DataAlreadyExistsException;
import com.pharma.inventory.exception.ProductNameNotExistException;
import com.pharma.inventory.model.Product;
import com.pharma.inventory.model.Response;

public interface ProductService {

	public Response setProductData(List<Product> productList) throws DataAlreadyExistsException, ProductNameNotExistException;
	
	public Response setProductData(Product product );
	
	public List<Product> getTopSoldProducts();

}
