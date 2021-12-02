package com.example.websitebanhang.dao;

import java.util.List;
import java.util.Optional;

import com.example.websitebanhang.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProductDao 
		extends JpaRepository<Product, Integer>{
	@Override
	List<Product> findAll();
	
	@Query("Select p FROM Product p WHERE p.category.id=?1")
	List<Product> findByCategoryId(String id);
//	Optional<Product> findById(Integer id);
	@Query("SELECT pr FROM Product pr WHERE pr.name LIKE %:name%")
    List<Product> getByName(@Param("name") String name);
	

}
