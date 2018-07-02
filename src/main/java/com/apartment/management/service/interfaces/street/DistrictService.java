package com.apartment.management.service.interfaces.street;

import java.util.List;

import com.apartment.management.model.street.City;
import com.apartment.management.model.street.District;
import com.apartment.management.service.interfaces.GeneralService;

public interface DistrictService extends GeneralService<District, Short>
{
	public List<District> getDistrictByCity(City city);
}
