package com.example.websitebanhang.restcontroller;

import java.util.List;

import com.example.websitebanhang.entity.Category;
import com.example.websitebanhang.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin()
@RestController
@RequestMapping("/rest/categories")
public class CategoryRestController {
	@Autowired
	CategoryService categorySer;
	
	@GetMapping()
	public List<Category> getAll(){
		return categorySer.findAll();
	}
	
	@PostMapping()
	public Category post(@RequestBody Category category) {
		categorySer.create(category);
		return category;
	}
	
	@PutMapping("{id}")
	public Category put(@PathVariable("id") Integer id, @RequestBody Category category) {
		categorySer.update(category);
		return category;

	}
	
	@DeleteMapping("{id}")
	private void delete(@PathVariable("id") String id) {
		categorySer.deleteById(id);

	}
	

}
