package com.consultadd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultadd.model.Customers;
import com.consultadd.repositry.CustomersRepositry;

@Service
public class CustomersServiceImpl implements CustomersService {

	@Autowired
	private CustomersRepositry customersRepositry;

	@Override
	public boolean saveCustomers(Customers customers) throws Exception {

		return customersRepositry.save(customers) != null;

	}

	@Override
	public void updateCustomers(Customers customers) throws Exception {

		Customers getCustomers = customersRepositry.findById(customers.getId()).get();

		getCustomers.setName(customers.getName());
		getCustomers.setAge(customers.getAge());
		getCustomers.setCity(customers.getCity());
		getCustomers.setPincode(customers.getPincode());
		
		customersRepositry.save(getCustomers);

	}

	@Override
	public void deleteCustomers(Long id) throws Exception {

		customersRepositry.deleteById(id);
	}

	@Override
	public Customers getCustomers(Long id) throws Exception {
		return customersRepositry.findById(id).get();
	}

	@Override
	public List<Customers> getAllCustomers() throws Exception {

		List<Customers> CustomersList = new ArrayList<>();
		customersRepositry.findAll().forEach(emp -> CustomersList.add(emp));

		return CustomersList;
	}

}
