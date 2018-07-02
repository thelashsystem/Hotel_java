package com.apartment.management.service.interfaces.business;

import java.util.List;

import com.apartment.management.model.business.RegisterService;
import com.apartment.management.service.interfaces.GeneralService;

public interface RegisterServiceService extends
		GeneralService<RegisterService, Integer>
{
	public List<RegisterService> getUnexpiredRegisteredService();
}
