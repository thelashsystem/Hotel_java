package com.apartment.management.service.interfaces.business;

import com.apartment.management.model.building.Service;
import com.apartment.management.model.business.ServicePrice;
import com.apartment.management.service.interfaces.GeneralService;

public interface ServicePriceService extends
		GeneralService<ServicePrice, Short>
{
	public ServicePrice getLastestServicePrice(Service service);
}
