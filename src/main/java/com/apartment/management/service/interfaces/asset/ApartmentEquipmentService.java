package com.apartment.management.service.interfaces.asset;

import java.util.List;

import com.apartment.management.model.asset.ApartmentEquipment;
import com.apartment.management.model.building.Apartment;
import com.apartment.management.service.interfaces.GeneralService;

public interface ApartmentEquipmentService extends
		GeneralService<ApartmentEquipment, Integer>
{
	public List<ApartmentEquipment> getUnhiddenEquipmentInApartment(
			Apartment apartment);

	public List<ApartmentEquipment> getAllEquipmentInApartment(
			Apartment apartment);
}
