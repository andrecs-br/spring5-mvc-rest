package acs.springfamework.spring5mvcrest.services;

import java.util.List;

import acs.springfamework.spring5mvcrest.api.v1.model.CustomerDTO;

public interface CustomerService {

	public List<CustomerDTO> getAllCustomers();
	
	public CustomerDTO getCustomerById(Long id);
	
	public CustomerDTO createNewCustomer(CustomerDTO customerDTO);
	
	public CustomerDTO saveCustomerByDTO(Long idCustomer, CustomerDTO customerDTO);

	public CustomerDTO patchCustomer(Long idCustomer, CustomerDTO customerDTO);

	public void deleteCustomer(Long idCustomer);
}
