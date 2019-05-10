package acs.springfamework.spring5mvcrest.controllers.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import acs.springfamework.spring5mvcrest.api.v1.model.CustomerDTO;
import acs.springfamework.spring5mvcrest.api.v1.model.CustomerListDTO;
import acs.springfamework.spring5mvcrest.services.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping
	public ResponseEntity<CustomerListDTO> getAllCustomers() {
		
		return new ResponseEntity<CustomerListDTO>(
				new CustomerListDTO(customerService.getAllCustomers()),
				HttpStatus.OK);
	}
	
	@GetMapping("/{idCustomer}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long idCustomer) {
		
		return new ResponseEntity<CustomerDTO>(
				customerService.getCustomerById(idCustomer),
				HttpStatus.OK);
	}
	
}
