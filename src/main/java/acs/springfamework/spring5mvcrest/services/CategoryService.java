package acs.springfamework.spring5mvcrest.services;

import java.util.List;

import acs.springfamework.spring5mvcrest.api.v1.model.CategoryDTO;

public interface CategoryService {
	
	List<CategoryDTO> getAllCategories();
	
	CategoryDTO getCategoryByName(String name);

}
