package com.example.websitebanhang.service;

import java.util.List;
import com.example.websitebanhang.entity.Account;


public interface AccountService {
	public List<Account> findAll();
	public Account findById(String username);

	public List<Account> getAdministrators();
	
	public void detele(String id);
	public Account create(Account ac);
	public Account update(Account ac);
	//đăng ký acc
	public Account save(Account ac);

	
	

}
