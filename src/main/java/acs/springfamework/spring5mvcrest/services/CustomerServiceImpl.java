package acs.springfamework.spring5mvcrest.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import acs.springfamework.spring5mvcrest.api.v1.mapper.CustomerMapper;
import acs.springfamework.spring5mvcrest.api.v1.model.CustomerDTO;
import acs.springfamework.spring5mvcrest.domain.Customer;
import acs.springfamework.spring5mvcrest.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Value("${api.customer.baseurl}")
	String baseUrl;

	private final CustomerRepository customerRepository;
	
	private final CustomerMapper customerMapper;

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		return customerRepository
				.findAll()
				.stream()
				.map(customer -> {  
					CustomerDTO dto = customerMapper.customerToCustomerDTO(customer);
					dto.setCustomerUrl(baseUrl + customer.getId());
					return dto;
				})
				.collect(Collectors.toList());
	}

	@Override
	public CustomerDTO getCustomerById(Long id) {
		Customer customer = customerRepository.findById(id).orElse(null);
		CustomerDTO result = null;
		
		if (customer !=  null) {
			result = customerMapper.customerToCustomerDTO(customer);
			result.setCustomerUrl(baseUrl + customer.getId());
		} 
		return result;
	}

	@Override
	public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
		Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
		
		return saveAndReturnDTO(customer);
	}

	private CustomerDTO saveAndReturnDTO(Customer customer) {
		customer = customerRepository.save(customer);
		
		CustomerDTO response = customerMapper.customerToCustomerDTO(customer);
		
		response.setCustomerUrl(baseUrl + customer.getId());
		
		return response;
	}

	@Override
	public CustomerDTO saveCustomerByDTO(Long idCustomer, CustomerDTO customerDTO) {
		Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
		
		customer.setId(idCustomer);
		
		return saveAndReturnDTO(customer);
	}

}
