package com.pharma.inventory.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pharma.inventory.dao.ProductDAO;
import com.pharma.inventory.model.Product;
import com.pharma.inventory.model.Response;

@Path("/product") 
@Consumes(MediaType.APPLICATION_JSON) 
@Produces(MediaType.APPLICATION_JSON)
public class ProductServiceImpl implements ProductService {

	@POST
	public Response setProductData(List<Product> productList) {
		ProductDAO.save(productList);
		return null;
	}

}
