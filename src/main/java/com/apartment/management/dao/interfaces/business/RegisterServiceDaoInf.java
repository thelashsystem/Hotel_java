package com.apartment.management.dao.interfaces.business;

import java.util.List;

import com.apartment.management.dao.interfaces.GeneralDao;
import com.apartment.management.model.business.RegisterService;

public interface RegisterServiceDaoInf extends
		GeneralDao<RegisterService, Integer>
{
	public List<RegisterService> getUnexpiredRegisteredService();
}
