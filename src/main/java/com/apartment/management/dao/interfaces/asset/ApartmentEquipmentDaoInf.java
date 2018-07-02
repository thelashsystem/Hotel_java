package com.apartment.management.dao.interfaces.asset;

import java.util.List;

import com.apartment.management.dao.interfaces.GeneralDao;
import com.apartment.management.model.asset.ApartmentEquipment;
import com.apartment.management.model.building.Apartment;

public interface ApartmentEquipmentDaoInf extends
		GeneralDao<ApartmentEquipment, Integer>
{
	public List<ApartmentEquipment> getUnhiddenEquipmentInApartment(
			Apartment apartment);

	public List<ApartmentEquipment> getAllEquipmentInApartment(
			Apartment apartment);
}
