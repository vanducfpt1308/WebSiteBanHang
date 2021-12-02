package com.example.websitebanhang.restcontroller;

import java.util.List;

import com.example.websitebanhang.entity.Product;
import com.example.websitebanhang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/rest/product")
public class ProductRestController {
	
	@Autowired
	ProductService prSer;
	
	
	
	@GetMapping()
	public List<Product> getAll() {
		return prSer.findAll();
	}
	@GetMapping("{id}")
	public Product getOne(@PathVariable("id") Integer id) {
		return prSer.findById(id);
		
	}

	@PostMapping()
	public Product post(@RequestBody Product product) {
		prSer.create(product);
		return product;
	}
	
	@PutMapping("{id}")
	public Product put(@PathVariable("id") Integer id, @RequestBody Product product) {
		// TODO Auto-generated method stub
		prSer.update(product);
		return product;

	}
	@DeleteMapping("{id}")
	private void delete(@PathVariable("id") Integer id) {
		prSer.deleteById(id);

	}
	
	
	

}
