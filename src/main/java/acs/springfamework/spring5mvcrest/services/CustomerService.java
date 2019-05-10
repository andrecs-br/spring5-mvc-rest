package acs.springfamework.spring5mvcrest.services;

import java.util.List;

import acs.springfamework.spring5mvcrest.api.v1.model.CustomerDTO;

public interface CustomerService {

	public List<CustomerDTO> getAllCustomers();
	
	public CustomerDTO getCustomerById(Long id);
	
}
