package com.apartment.management.service.imp.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.interfaces.business.ResourceDaoInf;
import com.apartment.management.model.business.Resource;
import com.apartment.management.service.interfaces.business.ResourceService;

@Component
@Service
@Transactional
public class ResourceServiceImp implements ResourceService
{
	@Autowired
	private ResourceDaoInf resourceDao;

	@Override
	public void add(Resource resource)
	{
		resourceDao.add(resource);
	}

	@Override
	public void update(Resource resource)
	{
		resourceDao.update(resource);
	}

	@Override
	public void delete(Resource resource)
	{
		resourceDao.delete(resource);
	}

	@Override
	public List<Resource> getAll()
	{
		return resourceDao.getAll();
	}

	@Override
	public Resource getById(Short id)
	{
		return resourceDao.getById(id);
	}

}
