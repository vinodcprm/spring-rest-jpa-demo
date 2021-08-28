package com.vkp.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vkp.demo.model.Customer;
import com.vkp.demo.repository.CustomerRepository;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@PostMapping("/customer")
	public Customer add(@RequestBody Customer customer) {
		Customer customerObj = customerRepository.save(customer);
		return customerObj;
	}
	
	@GetMapping("/customer")
	public List<Customer> getAll(){
		Iterable<Customer> customers = customerRepository.findAll();			
		return Streamable.of(customers).toList();
	}
	
	@GetMapping("/customer/{id}")
	public Customer get(@RequestParam long id) {
		return customerRepository.findById(id);
	}
	
	@GetMapping("/customer/{lastname}")
	public List<Customer> getByLastName(@RequestParam String lastname) {
		return customerRepository.findByLastName(lastname);
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<String> delete(@RequestParam long id) {
		customerRepository.deleteById(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
