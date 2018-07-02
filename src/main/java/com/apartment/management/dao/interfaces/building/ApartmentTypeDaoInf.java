package com.apartment.management.dao.interfaces.building;

import java.util.List;

import com.apartment.management.dao.interfaces.GeneralDao;
import com.apartment.management.model.building.ApartmentType;

public interface ApartmentTypeDaoInf extends GeneralDao<ApartmentType, Short>
{
	public ApartmentType getApartmentTypeByCode(String code);
	
	public List<ApartmentType> get3HighestApartmentType();
}
