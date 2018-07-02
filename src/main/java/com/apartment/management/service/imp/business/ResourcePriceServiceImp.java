package com.apartment.management.service.imp.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.interfaces.business.ResourcePriceDaoInf;
import com.apartment.management.model.business.Resource;
import com.apartment.management.model.business.ResourcePrice;
import com.apartment.management.service.interfaces.business.ResourcePriceService;

@Component
@Service
@Transactional
public class ResourcePriceServiceImp implements ResourcePriceService
{
	@Autowired
	private ResourcePriceDaoInf resourcePriceDao;

	@Override
	public void add(ResourcePrice resourcePrice)
	{
		resourcePriceDao.add(resourcePrice);
	}

	@Override
	public void update(ResourcePrice resourcePrice)
	{
		resourcePriceDao.update(resourcePrice);
	}

	@Override
	public void delete(ResourcePrice resourcePrice)
	{
		resourcePriceDao.delete(resourcePrice);
	}

	@Override
	public List<ResourcePrice> getAll()
	{
		return resourcePriceDao.getAll();
	}

	@Override
	public ResourcePrice getById(Integer id)
	{
		return resourcePriceDao.getById(id);
	}

	@Override
	public ResourcePrice getLastestResourcePrice(Resource resource)
	{
		return resourcePriceDao.getLastestResourcePrice(resource);
	}

}
