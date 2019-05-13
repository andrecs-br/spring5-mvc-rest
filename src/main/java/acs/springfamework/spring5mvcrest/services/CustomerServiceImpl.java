package acs.springfamework.spring5mvcrest.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import acs.springfamework.spring5mvcrest.api.v1.mapper.CustomerMapper;
import acs.springfamework.spring5mvcrest.api.v1.model.CustomerDTO;
import acs.springfamework.spring5mvcrest.domain.Customer;
import acs.springfamework.spring5mvcrest.exceptions.ResourceNotFoundException;
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
		return customerRepository.findById(id)
				.map(customer -> {
					CustomerDTO result = customerMapper.customerToCustomerDTO(customer);
					result.setCustomerUrl(baseUrl + customer.getId());
					return result;
				}).orElseThrow(ResourceNotFoundException::new);
		
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

	@Override
	public CustomerDTO patchCustomer(Long idCustomer, CustomerDTO customerDTO) {

		return customerRepository
				.findById(idCustomer)
				.map(customer -> {
					if (customerDTO.getFirstName() != null) {
						customer.setFirstName(customerDTO.getFirstName());
					}
					if (customerDTO.getLastName() != null) {
						customer.setLastName(customerDTO.getLastName());
					}

					return saveAndReturnDTO(customer);
				}).orElseThrow(ResourceNotFoundException::new);

	}

	@Override
	public void deleteCustomer(Long idCustomer) {
		this.getCustomerById(idCustomer); //just to validate costumer and throw an Exception if it doesn't exist
		customerRepository.deleteById(idCustomer);
	}

}
