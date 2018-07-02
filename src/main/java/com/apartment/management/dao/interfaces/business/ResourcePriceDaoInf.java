package com.apartment.management.dao.interfaces.business;

import com.apartment.management.dao.interfaces.GeneralDao;
import com.apartment.management.model.business.Resource;
import com.apartment.management.model.business.ResourcePrice;

public interface ResourcePriceDaoInf extends GeneralDao<ResourcePrice, Integer>
{
	public ResourcePrice getLastestResourcePrice(Resource resource);
}
