package acs.springfamework.spring5mvcrest.controllers.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import acs.springfamework.spring5mvcrest.api.v1.model.CategoryDTO;
import acs.springfamework.spring5mvcrest.api.v1.model.CategoryListDTO;
import acs.springfamework.spring5mvcrest.services.CategoryService;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
	
	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public CategoryListDTO getAllCategories() {
		
		return new CategoryListDTO(categoryService.getAllCategories());
	}
	
	@GetMapping("/{idCategory}")
	@ResponseStatus(HttpStatus.OK)
	public CategoryDTO getCategoryById(@PathVariable String idCategory) {
		
		return categoryService.getCategoryByName(idCategory);
	}
	
}
