package com.ecommerce.ecommerceproject.service;

import java.util.List;

import com.ecommerce.ecommerceproject.entity.Category;

public interface CategoryService {

	Category saveCategory(Category category);
	
	List<Category> getAllCategories();
	
	Category getCategoryById(Long id);
	
	void deleteCategory(Long id);
}
