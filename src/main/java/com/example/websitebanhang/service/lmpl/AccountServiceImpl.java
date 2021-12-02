package com.example.websitebanhang.service.lmpl;

import java.util.List;

import com.example.websitebanhang.dao.AccountDao;
import com.example.websitebanhang.entity.Account;
import com.example.websitebanhang.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountDao dao;
	
	@Override
	public Account findById(String username) {
		return dao.findById(username).get();
	}

	@Override
	public List<Account> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Account> getAdministrators() {
		return dao.getAdministrator();
	}

	@Override
	public void detele(String id) {
		dao.deleteById(id);
		
	}

	@Override
	public Account create(Account ac) {
		
		return dao.save(ac);
	}

	@Override
	public Account update(Account ac) {
		
		return dao.save(ac);
	}
    // đăng ký acc
	@Override
	public Account save(Account ac) {
		// TODO Auto-generated method stub
		return dao.save(ac);
	}

}
