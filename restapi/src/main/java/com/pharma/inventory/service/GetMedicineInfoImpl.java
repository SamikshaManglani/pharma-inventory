package com.pharma.inventory.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pharma.inventory.dao.ProductDAO;
import com.pharma.inventory.model.Product;

@Path("/medicineInfo") 
@Consumes(MediaType.APPLICATION_JSON) 
@Produces(MediaType.APPLICATION_JSON)
public class GetMedicineInfoImpl implements GetMedicineInfo {

	@GET
	@Path("/name/{name}")
	public Product getMedicineBasedOnName(@PathParam("name") String name) {
		return ProductDAO.getMedicineByName(name);
	}
	
	@GET
	@Path("/genericName/{name}")
	public List<Product> getMedicineBasedOnGenericName(@PathParam("name") String name) {
		return ProductDAO.getMedicineByGenericName(name);
	}

	@GET
	@Path("/categoryName/{name}")
	public List<Product> getMedicineBasedOnCategoryName(@PathParam("name") String name) {
		return ProductDAO.getMedicineByCategoryName(name);
	}

}