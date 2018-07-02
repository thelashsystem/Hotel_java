package com.apartment.management.service.interfaces.building;

import java.util.List;

import com.apartment.management.model.building.ApartmentType;
import com.apartment.management.service.interfaces.GeneralService;

public interface ApartmentTypeService extends
		GeneralService<ApartmentType, Short>
{
	public abstract List<ApartmentType> getAllApartmentType();

	public abstract ApartmentType getApartmentTypeByCode(String code);
	
	public List<ApartmentType> get3HighestApartmentType();
}
