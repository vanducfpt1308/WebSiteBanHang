package com.example.websitebanhang.restcontroller;

import java.util.List;
import java.util.Optional;

import com.example.websitebanhang.entity.Authority;
import com.example.websitebanhang.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/authorities")
public class AuthorityRestController {
	@Autowired
	AuthorityService auSer;
	
	@GetMapping
	public List<Authority> findAll(@RequestParam("admin") Optional<Boolean>admin){
		if(admin.orElse(false)) {//NẾU LÀ TRUE LẤY RA CÁC QUYỀN CÂP CHO ADMIN
			return auSer.findAuthoritiesOfAdministrator();
		}
		return auSer.findAll();
	}
	@GetMapping("/all")
	public List<Authority> put() {
		return auSer.findAll();
	}
	@PostMapping
	public Authority post(@RequestBody Authority auth) {
		return auSer.create(auth);
	}
	@PutMapping("{id}")
	public Authority put(@PathVariable("id") Integer id, @RequestBody Authority au) {
		// TODO Auto-generated method stub
		auSer.update(au);
		return au;

	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		auSer.detele(id);
	}
	

}
