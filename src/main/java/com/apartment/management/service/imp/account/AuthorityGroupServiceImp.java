package com.apartment.management.service.imp.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.interfaces.account.AuthorityGroupDaoInf;
import com.apartment.management.model.account.AuthorityGroup;
import com.apartment.management.service.interfaces.account.AuthorityGroupService;

@Component
@Service
@Transactional
public class AuthorityGroupServiceImp implements AuthorityGroupService
{
	@Autowired
	private AuthorityGroupDaoInf authorityGroupDaoInf;

	@Override
	public void add(AuthorityGroup authorityGroup)
	{
		authorityGroupDaoInf.add(authorityGroup);
	}

	@Override
	public void update(AuthorityGroup authorityGroup)
	{
		authorityGroupDaoInf.update(authorityGroup);
	}

	@Override
	public void delete(AuthorityGroup authorityGroup)
	{
		authorityGroupDaoInf.delete(authorityGroup);
	}

	@Override
	public List<AuthorityGroup> getAll()
	{
		return authorityGroupDaoInf.getAll();
	}

	@Override
	public AuthorityGroup getById(Short id)
	{
		return authorityGroupDaoInf.getById(id);
	}

}
