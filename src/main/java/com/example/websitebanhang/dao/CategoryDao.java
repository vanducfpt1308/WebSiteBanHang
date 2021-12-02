package com.example.websitebanhang.dao;

import java.util.List;

import com.example.websitebanhang.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryDao extends JpaRepository<Category, String>{
	@Override
	List<Category> findAll();

}
