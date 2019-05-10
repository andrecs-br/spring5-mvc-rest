package acs.springfamework.spring5mvcrest.controllers.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<CategoryListDTO> getAllCategories() {
		
		return new ResponseEntity<CategoryListDTO>(
				new CategoryListDTO(categoryService.getAllCategories()),
				HttpStatus.OK);
	}
	
	@GetMapping("/{idCategory}")
	public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable String idCategory) {
		
		return new ResponseEntity<CategoryDTO>(
				categoryService.getCategoryByName(idCategory),
				HttpStatus.OK);
	}
	
}
