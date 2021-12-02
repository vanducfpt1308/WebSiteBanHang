package com.example.websitebanhang.service.lmpl;

import java.util.List;

import com.example.websitebanhang.dao.RoleDao;
import com.example.websitebanhang.entity.Role;
import com.example.websitebanhang.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleDao rDao;

	@Override
	public List<Role> findAll() {
		return rDao.findAll();
	}
	

}
