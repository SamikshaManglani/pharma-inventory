package com.pharma.inventory.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pharma.inventory.dao.CategoryDAO;
import com.pharma.inventory.model.Category;
import com.pharma.inventory.model.Response;
import com.pharma.inventory.service.CategoryService;

@Path("/category") 
@Consumes(MediaType.APPLICATION_JSON) 
@Produces(MediaType.APPLICATION_JSON)
public class CategoryServiceImpl implements CategoryService {

	@POST
	public Response setCategoryData(Category c) {
		int k = CategoryDAO.save(c);
		Response response = new Response();
		response.setMessage("Category saved "+k);
		response.setStatus(true);
		return response;
	}

}
