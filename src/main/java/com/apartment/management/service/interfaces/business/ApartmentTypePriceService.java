package com.apartment.management.service.interfaces.business;

import com.apartment.management.model.building.ApartmentType;
import com.apartment.management.model.business.ApartmentTypePrice;
import com.apartment.management.service.interfaces.GeneralService;

public interface ApartmentTypePriceService extends
		GeneralService<ApartmentTypePrice, Integer>
{
	public ApartmentTypePrice getLastestApartmentTypePrice(
			ApartmentType apartmentType);
}
