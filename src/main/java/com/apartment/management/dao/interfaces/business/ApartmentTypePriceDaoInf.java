package com.apartment.management.dao.interfaces.business;

import com.apartment.management.dao.interfaces.GeneralDao;
import com.apartment.management.model.building.ApartmentType;
import com.apartment.management.model.business.ApartmentTypePrice;

public interface ApartmentTypePriceDaoInf extends
		GeneralDao<ApartmentTypePrice, Integer>
{
	public ApartmentTypePrice getLastestApartmentTypePrice(
			ApartmentType apartmentType);
}
