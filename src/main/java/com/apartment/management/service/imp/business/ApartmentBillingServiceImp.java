package com.apartment.management.service.imp.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.interfaces.business.ApartmentBillingDaoInf;
import com.apartment.management.model.business.ApartmentBilling;
import com.apartment.management.service.interfaces.business.ApartmentBillingService;

@Component
@Service
@Transactional
public class ApartmentBillingServiceImp implements ApartmentBillingService
{
	@Autowired
	private ApartmentBillingDaoInf apartmentBillingDao;

	@Override
	public void add(ApartmentBilling obj)
	{
		apartmentBillingDao.add(obj);
	}

	@Override
	public void update(ApartmentBilling obj)
	{
		apartmentBillingDao.update(obj);
	}

	@Override
	public void delete(ApartmentBilling obj)
	{
		apartmentBillingDao.delete(obj);
	}

	@Override
	public List<ApartmentBilling> getAll()
	{
		return apartmentBillingDao.getAll();
	}

	@Override
	public ApartmentBilling getById(Long id)
	{
		return apartmentBillingDao.getById(id);
	}

}
