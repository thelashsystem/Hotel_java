package com.apartment.management.dao.interfaces.building;

import java.util.List;

import com.apartment.management.dao.interfaces.GeneralDao;
import com.apartment.management.model.building.Apartment;
import com.apartment.management.model.building.ApartmentType;

public interface ApartmentDaoInf extends GeneralDao<Apartment, Integer>
{
	public List<Apartment> get3PopularApartmentFromApartmentType(
			ApartmentType apartmentType);

	public List<Apartment> get3RandomApartmentFromApartmentType(
			ApartmentType apartmentType);
	
	public Apartment getRandomApartmentFromApartmentType(ApartmentType apartmentType);
	
	public List<Apartment> getAvailableApartment();
}
