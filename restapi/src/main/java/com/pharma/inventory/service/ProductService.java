package com.pharma.inventory.service;

import java.util.List;

import com.pharma.inventory.model.Product;
import com.pharma.inventory.model.Response;

public interface ProductService {

	public Response setProductData(List<Product> productList);
}
