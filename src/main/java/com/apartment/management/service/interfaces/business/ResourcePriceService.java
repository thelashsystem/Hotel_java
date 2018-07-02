package com.apartment.management.service.interfaces.business;

import com.apartment.management.model.business.Resource;
import com.apartment.management.model.business.ResourcePrice;
import com.apartment.management.service.interfaces.GeneralService;

public interface ResourcePriceService extends
		GeneralService<ResourcePrice, Integer>
{
	public ResourcePrice getLastestResourcePrice(Resource resource);
}
