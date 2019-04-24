package com.consultadd.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.consultadd.model.Customers;
import com.consultadd.service.CustomersService;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins = "*")
public class CustomerController {

	@Autowired
	private CustomersService customersService;

	@PostMapping("/create")
	public ResponseEntity<Void> callSaveCustomers(@RequestBody Customers customers, UriComponentsBuilder builder)
			throws Exception {

		boolean flag = customersService.saveCustomers(customers);
		if (flag == false) {

			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/create?id={id}").buildAndExpand(customers.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}

	@PutMapping("/update")
	public ResponseEntity<Customers> callUpdateCustomers(@RequestBody Customers customers) throws Exception {

		customersService.updateCustomers(customers);

		return new ResponseEntity<Customers>(customers, HttpStatus.OK);

	}

	@DeleteMapping("/delete")
	public ResponseEntity<Void> callDeleteCustomers(@PathParam("id") Long id) throws Exception {
		customersService.deleteCustomers(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/edit")
	public ResponseEntity<Customers> callGetCustomers(@PathParam("id") Long id) throws Exception {
		Customers customers = customersService.getCustomers(id);
		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}

	@GetMapping("/fetch")
	public ResponseEntity<List<Customers>> getAllCustomers() throws Exception {
		List<Customers> CustomersList = customersService.getAllCustomers();
		return new ResponseEntity<List<Customers>>(CustomersList, HttpStatus.OK);
	}

}
