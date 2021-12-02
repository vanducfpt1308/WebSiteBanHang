package com.example.websitebanhang.service;

import com.example.websitebanhang.entity.Category;

import java.util.List;


public interface CategoryService {

	List<Category> findAll();

	Category create(Category category);

	Category update(Category category);

	void deleteById(String id);

}
