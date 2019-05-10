package acs.springfamework.spring5mvcrest.api.v1.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import acs.springfamework.spring5mvcrest.api.v1.model.CustomerDTO;
import acs.springfamework.spring5mvcrest.domain.Customer;

public class CustomerMapperTest {

	public static long ID = 1L;

	public static String FIRSTNAME = "Andre";

	public static String LASTNAME = "Silva";

	@Test
	public void testCustomerToCustomerDTO() {
		Customer customer = new Customer();
		customer.setId(ID);
		customer.setFirstName(FIRSTNAME);
		customer.setLastName(LASTNAME);
		
		CustomerDTO dto = CustomerMapper.INSTANCE.customerToCustomerDTO(customer);
		
		assertEquals(FIRSTNAME, dto.getFirstName());
		assertEquals(LASTNAME, dto.getLastName());
		
	}

	@Test
	public void testCustomerDTOToCustomer() {
		CustomerDTO dto = new CustomerDTO();
		dto.setFirstName(FIRSTNAME);
		dto.setLastName(LASTNAME);
		
		Customer customer = CustomerMapper.INSTANCE.customerDTOToCustomer(dto);
		
		assertEquals(FIRSTNAME, customer.getFirstName());
		assertEquals(LASTNAME, customer.getLastName());
		
	}

}
