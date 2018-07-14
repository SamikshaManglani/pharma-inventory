package com.pharma.inventory.service;

import com.pharma.inventory.exception.InvoiceDoesNotExistException;
import com.pharma.inventory.model.Invoice;

public interface InvoiceService {

	public Invoice getInvoice(int id) throws InvoiceDoesNotExistException;
}
