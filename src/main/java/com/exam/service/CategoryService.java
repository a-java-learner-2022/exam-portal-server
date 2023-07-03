package com.exam.service;

import java.util.Set;

import com.exam.model.exam.Category;

public interface CategoryService {
	
	public Category addCategory(Category category);
	
	public Category upadateCategory(Category category);
	
	public Set<Category> getCategories();
	
	public Category getById(Long categeoryId);
	
	public void deleteCategory(Long categoryId);

}