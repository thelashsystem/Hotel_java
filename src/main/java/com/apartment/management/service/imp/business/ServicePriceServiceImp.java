package com.apartment.management.service.imp.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.imp.business.ServicePriceDao;
import com.apartment.management.model.building.Service;
import com.apartment.management.model.business.ServicePrice;
import com.apartment.management.service.interfaces.business.ServicePriceService;

@Component
@org.springframework.stereotype.Service
@Transactional
public class ServicePriceServiceImp implements ServicePriceService
{
	@Autowired
	private ServicePriceDao servicePriceDao;

	@Override
	public void add(ServicePrice servicePrice)
	{
		servicePriceDao.add(servicePrice);
	}

	@Override
	public void update(ServicePrice servicePrice)
	{
		servicePriceDao.update(servicePrice);
	}

	@Override
	public void delete(ServicePrice servicePrice)
	{
		servicePriceDao.delete(servicePrice);
	}

	@Override
	public List<ServicePrice> getAll()
	{
		return servicePriceDao.getAll();
	}

	@Override
	public ServicePrice getById(Short id)
	{
		return servicePriceDao.getById(id);
	}

	@Override
	public ServicePrice getLastestServicePrice(Service service)
	{
		return servicePriceDao.getLastestServicePrice(service);
	}

}
