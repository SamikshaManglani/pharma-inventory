package com.pharma.inventory.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pharma.inventory.dao.InvoiceDAO;
import com.pharma.inventory.model.Invoice;
import com.pharma.inventory.model.Order;
import com.pharma.inventory.model.Response;
import com.pharma.inventory.service.InvoiceService;


@Path("/invoice") 
@Consumes(MediaType.APPLICATION_JSON) 
@Produces(MediaType.APPLICATION_JSON)
public class InvoiceServiceImpl implements InvoiceService {

	@GET
	@Path("/{id}")
	public Invoice getInvoice(@PathParam("id") int id) {
		return InvoiceDAO.getById(id);
	}

	@POST
	public Response setInvoice(Order order){
		int k = InvoiceDAO.create(order);
		Response response = new Response();
		response.setStatus(true);
		response.setMessage("Post works!!" + k);
		return response;
	}
}
