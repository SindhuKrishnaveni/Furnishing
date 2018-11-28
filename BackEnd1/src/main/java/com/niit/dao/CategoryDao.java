package com.niit.dao;

import java.util.List;

import com.niit.model.Category;

public interface CategoryDao {
	public Category addCategory(Category category);
	public List<Category>getAllCategory();
	public void updateCategory(Category category);
	public void deleteCategory(int id);
	public Category selectCategory(int id);

}
