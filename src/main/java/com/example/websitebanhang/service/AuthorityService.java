package com.example.websitebanhang.service;

import java.util.List;

import com.example.websitebanhang.entity.Authority;

public interface AuthorityService {

	public List<Authority> findAuthoritiesOfAdministrator();

	public List<Authority> findAll();

	public Authority create(Authority auth);

	public void detele(Integer id);

	public Authority update(Authority au);


}
