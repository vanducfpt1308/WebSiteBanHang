package com.example.websitebanhang.service.lmpl;

import java.util.List;

import com.example.websitebanhang.dao.ProductDao;
import com.example.websitebanhang.entity.Product;
import com.example.websitebanhang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServicelmpl implements ProductService {
	@Autowired
	ProductDao pDao;
	@Override
	public List<Product> findAll() {
		
		return pDao.findAll();
	}
	@Override
	public Product findById(Integer id) {
		
		return pDao.findById(id).get();
	}
	@Override
	public List<Product> findByCategoryId(String id) {
	
		return pDao.findByCategoryId(id);
	}
	@Override
	public Product create(Product product) {		
		return pDao.save(product);
	}
	@Override
	public Product update(Product product) {
		return pDao.save(product);
	}
	@Override
	public void deleteById(Integer id) {
		
		pDao.deleteById(id);
	}
	@Override
	public List<Product> getByName(String name) {
	
		return pDao.getByName(name);
	}
	
	
	

}
