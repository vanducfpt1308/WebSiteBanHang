package com.example.websitebanhang.controller;

import javax.validation.Valid;

import com.example.websitebanhang.dao.AuthorityDao;
import com.example.websitebanhang.dao.RoleDao;
import com.example.websitebanhang.entity.Account;
import com.example.websitebanhang.entity.Authority;
import com.example.websitebanhang.entity.Role;
import com.example.websitebanhang.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginSecurityController {
	
	@Autowired
	AccountService acSer;
	
	@Autowired
	AuthorityDao authoritiDao;
	
	@Autowired
	RoleDao roleDao;
	
	@RequestMapping("/login/form")
	public String loginForm(Model model) {
		model.addAttribute("message","Vui lòng đăng nhập");
		return "security/login";
	}
	
	@RequestMapping("/login/success")
	public String loginSuccess(Model model) {
		model.addAttribute("message","Đăng nhập thành công");
		return "security/login";
	}
	
	@RequestMapping("/login/error")
	public String loginError(Model model) {
		model.addAttribute("message","Sai thông tin tài khoản hoặc mật khẩu");
		return "security/login";
	}
	
	
	@RequestMapping("/unauthoried")
	public String unauthoried(Model model) {
		model.addAttribute("message","Bạn không có quyền truy xuất!");
		return "security/login";
	}
	
	@RequestMapping("/logoff/success")
	public String logoffSuccess(Model model) {
		model.addAttribute("message","Bạn đã đăng xuất");
		return "security/login";
	}
	
	@GetMapping("/login/register")
	public String register(Model model) {
		Account ac = new Account();
		model.addAttribute("ac", ac);
		return "security/rigisterUser";
	}
	
	 @PostMapping("/user/save")
	  	public String insert(Model model, @Valid @ModelAttribute("ac") Account ac, 
	  			 Errors errors) {
		
		 if(errors.hasErrors()) {
			 model.addAttribute("message", "Vui lòng sửa các lỗi sau");
			 
			 return "security/rigisterUser";
		 }else {
			
			 model.addAttribute("message", "Đăng ký thành công");
				String id = "CUST";
				acSer.save(ac);
		        Authority authority = new Authority();
		        Role role = roleDao.findById(id).get();
		        authority.setAccount(ac);
		        authority.setRole(role);
		        authoritiDao.save(authority);
		        
		      
			 
		 }	 
		 
	  	return "security/rigisterUser";
	  }
	
}
