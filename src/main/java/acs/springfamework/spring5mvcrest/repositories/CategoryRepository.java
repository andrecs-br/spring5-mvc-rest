package acs.springfamework.spring5mvcrest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import acs.springfamework.spring5mvcrest.domain.Category;

/**
 * Created by jt on 9/24/17.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	public Optional<Category> findByName(String name);
	
}
