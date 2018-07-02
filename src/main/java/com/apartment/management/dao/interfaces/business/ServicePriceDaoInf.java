package com.apartment.management.dao.interfaces.business;

import com.apartment.management.dao.interfaces.GeneralDao;
import com.apartment.management.model.building.Service;
import com.apartment.management.model.business.ServicePrice;

public interface ServicePriceDaoInf extends GeneralDao<ServicePrice, Short>
{
	public ServicePrice getLastestServicePrice(Service service);
}
