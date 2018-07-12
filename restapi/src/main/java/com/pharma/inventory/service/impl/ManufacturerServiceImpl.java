package com.pharma.inventory.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pharma.inventory.dao.ManufacturerDAO;
import com.pharma.inventory.model.Manufacturer;
import com.pharma.inventory.model.Response;
import com.pharma.inventory.service.ManufacturerService;

@Path("/manufacturer") 
@Consumes(MediaType.APPLICATION_JSON) 
@Produces(MediaType.APPLICATION_JSON)
public class ManufacturerServiceImpl implements ManufacturerService {

	@POST
	public Response setManufacturerData(Manufacturer manufacturer) {
		int k = ManufacturerDAO.save(manufacturer);
		Response response = new Response();
		response.setMessage("Manufacturer saved "+k);
		response.setStatus(true);
		return response;
	}

}
