package acs.springfamework.spring5mvcrest.controllers.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import acs.springfamework.spring5mvcrest.api.v1.model.CustomerDTO;
import acs.springfamework.spring5mvcrest.api.v1.model.CustomerListDTO;
import acs.springfamework.spring5mvcrest.services.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags={"Customers"})
@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

	public static final String BASE_URL = "/api/v1/customers";
	
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@ApiOperation(value="Return all customers.", 
			notes="Some notes here.",
			produces="application/JSON",
			response=CustomerListDTO.class)
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public CustomerListDTO getAllCustomers() {
		
		return new CustomerListDTO(customerService.getAllCustomers());
	}
	
	@ApiOperation(value="Return a specific customer.", 
			notes="Some notes here.",
			produces="application/JSON",
			response=CustomerDTO.class)
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Customer successfully encountered"),
			@ApiResponse(code=404, message="Customer didn't find")
	})
	@GetMapping("/{idCustomer}")
	@ResponseStatus(HttpStatus.OK)
	public CustomerDTO getCustomerById(@PathVariable Long idCustomer) {
		
		return customerService.getCustomerById(idCustomer);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createNewCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.createNewCustomer(customerDTO);
    }
	
	@PutMapping("/{idCustomer}")
	@ResponseStatus(HttpStatus.OK)
	public CustomerDTO updateCustomer(@PathVariable Long idCustomer, @RequestBody CustomerDTO customerDTO){
        return customerService.saveCustomerByDTO(idCustomer, customerDTO);
    }

	@PatchMapping("/{idCustomer}")
	@ResponseStatus(HttpStatus.OK)
	public CustomerDTO patchCustomer(@PathVariable Long idCustomer, @RequestBody CustomerDTO customerDTO){
        return customerService.patchCustomer(idCustomer, customerDTO);
    }
	
	@DeleteMapping("/{idCustomer}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteCustomer(@PathVariable Long idCustomer) {
		customerService.deleteCustomer(idCustomer);
    }

}
