package com.apartment.management.service.imp.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.imp.business.ServiceBillingDao;
import com.apartment.management.model.business.ServiceBilling;
import com.apartment.management.service.interfaces.business.ServiceBillingService;

@Component
@Service
@Transactional
public class ServiceBillingServiceImp implements ServiceBillingService
{
	@Autowired
	private ServiceBillingDao serviceBillingDao;

	@Override
	public void add(ServiceBilling billDetail)
	{
		serviceBillingDao.add(billDetail);
	}

	@Override
	public void update(ServiceBilling billDetail)
	{
		serviceBillingDao.update(billDetail);
	}

	@Override
	public void delete(ServiceBilling billDetail)
	{
		serviceBillingDao.delete(billDetail);
	}

	@Override
	public List<ServiceBilling> getAll()
	{
		return serviceBillingDao.getAll();
	}

	@Override
	public ServiceBilling getById(Long id)
	{
		return serviceBillingDao.getById(id);
	}

}
