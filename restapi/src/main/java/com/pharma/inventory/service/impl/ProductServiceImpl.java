package com.pharma.inventory.service.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pharma.inventory.dao.ProductDAO;
import com.pharma.inventory.model.Product;
import com.pharma.inventory.model.Response;
import com.pharma.inventory.service.ProductService;

@Path("/product") 
@Consumes(MediaType.APPLICATION_JSON) 
@Produces(MediaType.APPLICATION_JSON)
public class ProductServiceImpl implements ProductService {

	@POST
	@Path("/list")
	public Response setProductData(List<Product> productList) {
		ProductDAO.save(productList);
		Response response = new Response();
		response.setMessage("All products Succesfully saved");
		response.setStatus(true);
		return response;
	}

	@GET
	public List<Product> getTopSoldProducts() {
		return ProductDAO.getTopSoldProducts(10);
	}

	@POST
	public Response setProductData(Product product) {
		ProductDAO.upsert(product);
		Response response = new Response();
		response.setMessage("Succesfully saved");
		response.setStatus(true);
		return response;
	}

}
