package acs.springfamework.spring5mvcrest.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import acs.springfamework.spring5mvcrest.domain.Category;
import acs.springfamework.spring5mvcrest.domain.Customer;
import acs.springfamework.spring5mvcrest.repositories.CategoryRepository;
import acs.springfamework.spring5mvcrest.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner{

	private CategoryRepository categoryRepository;
	
	private CustomerRepository customerRepository;

	@Autowired
	public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
		this.categoryRepository = categoryRepository;
		this.customerRepository = customerRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		loadCategories();
        
        loadCustomers();

        log.debug("Data Category Loaded = " + categoryRepository.count());
        log.debug("Data Customer Loaded = " + customerRepository.count());

	}

	private void loadCustomers() {
		Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("Andre");
        customer.setLastName("Silva");

        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setFirstName("Leandro");
        customer2.setLastName("Silva");
        
        customerRepository.save(customer);
        customerRepository.save(customer2);
	}

	private void loadCategories() {
		Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);
	}
	
}
