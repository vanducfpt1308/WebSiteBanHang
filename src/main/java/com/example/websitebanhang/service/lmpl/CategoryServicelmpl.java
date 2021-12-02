package com.example.websitebanhang.service.lmpl;

import java.util.List;

import com.example.websitebanhang.dao.CategoryDao;
import com.example.websitebanhang.entity.Category;
import com.example.websitebanhang.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServicelmpl implements CategoryService {
	@Autowired
	CategoryDao cDao;

	@Override
	public List<Category> findAll() {
	
		return cDao.findAll();
	}

	@Override
	public Category create(Category category) {
		return cDao.save(category);
	}

	@Override
	public Category update(Category category) {
		return cDao.save(category);
	}

	@Override
	public void deleteById(String id) {
		cDao.deleteById(id);
		
	}

}
