package com.apartment.management.service.imp.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.interfaces.business.ResourceBillingDaoInf;
import com.apartment.management.model.business.ResourceBilling;
import com.apartment.management.service.interfaces.business.ResourceBillingService;

@Component
@Service
@Transactional
public class ResourceBillingServiceImp implements ResourceBillingService
{
	@Autowired
	private ResourceBillingDaoInf resourceBillingDao;

	@Override
	public void add(ResourceBilling billDetail)
	{
		resourceBillingDao.add(billDetail);
	}

	@Override
	public void update(ResourceBilling billDetail)
	{
		resourceBillingDao.update(billDetail);
	}

	@Override
	public void delete(ResourceBilling billDetail)
	{
		resourceBillingDao.delete(billDetail);
	}

	@Override
	public List<ResourceBilling> getAll()
	{
		return resourceBillingDao.getAll();
	}

	@Override
	public ResourceBilling getById(Long id)
	{
		return resourceBillingDao.getById(id);
	}

	@Override
	public void calcResourceBilling()
	{

	}

}
