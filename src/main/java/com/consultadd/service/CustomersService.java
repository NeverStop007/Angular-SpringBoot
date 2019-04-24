package com.consultadd.service;

import java.util.List;

import com.consultadd.model.Customers;



public interface CustomersService {

	
	
    public boolean saveCustomers(Customers customers) throws Exception;
	
	public void updateCustomers(Customers customers) throws Exception;
	
	public void deleteCustomers(Long id) throws Exception;
	
	public Customers getCustomers(Long id) throws Exception;
					
	public List<Customers> getAllCustomers() throws Exception;
}
