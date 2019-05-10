package acs.springfamework.spring5mvcrest.api.v1.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import acs.springfamework.spring5mvcrest.api.v1.model.CategoryDTO;
import acs.springfamework.spring5mvcrest.domain.Category;

public class CategoryMapperTest {

	public static final String NAME = "Joe";
    public static final long ID = 1L;

    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Test
    public void categoryToCategoryDTO() throws Exception {

        //given
        Category category = new Category();
        category.setName(NAME);
        category.setId(ID);

        //when
        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

        //then
        assertEquals(Long.valueOf(ID), categoryDTO.getId());
        assertEquals(NAME, categoryDTO.getName());
    }

}
