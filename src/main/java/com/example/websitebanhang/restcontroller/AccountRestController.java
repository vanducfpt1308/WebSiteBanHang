package com.example.websitebanhang.restcontroller;

import java.util.List;
import java.util.Optional;

import com.example.websitebanhang.entity.Account;
import com.example.websitebanhang.service.AccountService;
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
@RequestMapping("/rest/accounts")
public class AccountRestController {
	@Autowired
	AccountService acSer;
	
	@GetMapping
	public List<Account> getAccounts(@RequestParam("admin") Optional<Boolean>admin){
		if(admin.orElse(false)) {
			return acSer.getAdministrators();
		}
		return acSer.findAll();
	}
	@PostMapping
	public Account post(@RequestBody Account ac) {
		return acSer.create(ac);
	}
	
	@PutMapping("{id}")
	public Account put(@PathVariable("id") String id, @RequestBody Account ac) {
		acSer.update(ac);
		return ac;

	}
	
	@DeleteMapping("{username}")
	public void delete(@PathVariable("username") String id) {
		acSer.detele(id);
	}
	
}
	
	


