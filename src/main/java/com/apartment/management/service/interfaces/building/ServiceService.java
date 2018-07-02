package com.apartment.management.service.interfaces.building;

import java.util.List;

import com.apartment.management.model.building.Service;
import com.apartment.management.service.interfaces.GeneralService;

public interface ServiceService extends GeneralService<Service, Short>
{
	public List<Service> getRegisteredService();
}
