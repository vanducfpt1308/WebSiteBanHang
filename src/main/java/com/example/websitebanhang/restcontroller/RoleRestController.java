package com.example.websitebanhang.restcontroller;

import java.util.List;

import com.example.websitebanhang.entity.Role;
import com.example.websitebanhang.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/roles")
public class RoleRestController {
	
	@Autowired
	RoleService roleSer;
	
	@GetMapping()
	public List<Role> getAll(){
		return roleSer.findAll();
	}
	

}
