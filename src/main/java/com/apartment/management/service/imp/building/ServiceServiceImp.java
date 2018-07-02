package com.apartment.management.service.imp.building;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.interfaces.building.ServiceDaoInf;
import com.apartment.management.model.building.Service;
import com.apartment.management.service.interfaces.building.ServiceService;

@Component
@org.springframework.stereotype.Service
@Transactional
public class ServiceServiceImp implements ServiceService
{
	@Autowired
	private ServiceDaoInf serviceDao;

	@Override
	public void add(Service service)
	{
		serviceDao.add(service);
	}

	@Override
	public void update(Service service)
	{
		serviceDao.update(service);
	}

	@Override
	public void delete(Service service)
	{
		serviceDao.delete(service);
	}

	@Override
	public List<Service> getAll()
	{
		return serviceDao.getAll();
	}

	@Override
	public Service getById(Short id)
	{
		return serviceDao.getById(id);
	}

	@Override
	public List<Service> getRegisteredService()
	{
		return null;
	}

}
