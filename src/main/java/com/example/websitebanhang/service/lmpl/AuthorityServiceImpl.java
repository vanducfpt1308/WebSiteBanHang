package com.example.websitebanhang.service.lmpl;

import java.util.List;

import com.example.websitebanhang.dao.AccountDao;
import com.example.websitebanhang.dao.AuthorityDao;
import com.example.websitebanhang.entity.Account;
import com.example.websitebanhang.entity.Authority;
import com.example.websitebanhang.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements AuthorityService {
	@Autowired
	AuthorityDao dao;
	
	@Autowired
	AccountDao acDao;



	@Override
	public List<Authority> findAll() {

		return dao.findAll();
	}

	@Override
	public Authority create(Authority auth) {
		return dao.save(auth);
	}

	@Override
	public void detele(Integer id) {
		dao.deleteById(id);
		
	}
	@Override
	public List<Authority> findAuthoritiesOfAdministrator() {
		List<Account> ac = acDao.getAdministrator();
		return dao.authoritiesOf(ac);
	}

	@Override
	public Authority update(Authority au) {
		
		return dao.save(au);
	}

}
