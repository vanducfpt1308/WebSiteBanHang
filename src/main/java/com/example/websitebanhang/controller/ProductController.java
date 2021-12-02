package com.example.websitebanhang.controller;

import java.util.List;
import java.util.Optional;

import com.example.websitebanhang.entity.Product;
import com.example.websitebanhang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	@RequestMapping("/product")
	 public String list(Model model, @RequestParam("id") Optional<String> id) {
		if(id.isPresent()) {
			List<Product> listSp = productService.findByCategoryId(id.get());
			model.addAttribute("listsp", listSp);
			
		}else {
			List<Product> listSp = productService.findAll();
			model.addAttribute("listsp", listSp);
			
		}
	
		return "product/listSp";
	}
	
	@RequestMapping("/product/detail/{id}")
	public String detail(Model model,@PathVariable("id")Integer id) {
		Product listSp = productService.findById(id);
		model.addAttribute("item", listSp);
		return "product/detail";
	}
	@GetMapping("/search")
    public String getByName(Model model, @RequestParam String name){
        List<Product> search = productService.getByName(name);
        model.addAttribute("listsp", search);
        return "product/listSP";
    }
}
