package com.vkp.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vkp.demo.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	Customer findById(long id);
	List<Customer> findByLastName(String lastName);
}
