package com.apartment.management.service.imp.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.interfaces.account.PermissionDaoInf;
import com.apartment.management.model.account.Permission;
import com.apartment.management.service.interfaces.account.PermissionService;

@Component
@Service
@Transactional
public class PermissionServiceImp implements PermissionService
{
	@Autowired
	private PermissionDaoInf permissionDao;

	@Override
	public void add(Permission permission)
	{
		permissionDao.add(permission);
	}

	@Override
	public void update(Permission permission)
	{
		permissionDao.update(permission);
	}

	@Override
	public void delete(Permission permission)
	{
		permissionDao.delete(permission);
	}

	@Override
	public List<Permission> getAll()
	{
		return permissionDao.getAll();
	}

	@Override
	public Permission getById(Short id)
	{
		return permissionDao.getById(id);
	}

}
