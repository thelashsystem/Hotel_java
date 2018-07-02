package com.apartment.management.service.interfaces.building;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.apartment.management.model.building.Apartment;
import com.apartment.management.model.building.ApartmentType;
import com.apartment.management.model.building.Building;
import com.apartment.management.model.street.City;
import com.apartment.management.service.interfaces.GeneralService;

public interface ApartmentService extends GeneralService<Apartment, Integer>
{
	public List<Apartment> getAllApartment();

	public List<Apartment> get3PopularApartmentFromApartmentType(
			ApartmentType apartmentType);

	public List<Apartment> get3RandomApartmentFromApartmentType(
			ApartmentType apartmentType);

	public Page<Apartment> findByBuildingAndApartmentType(Building building,
			ApartmentType apartmentType, Double price, Integer numGuest,
			Pageable pageable);

	public Page<Apartment> findByCityAndApartmentType(City city,
			ApartmentType apartmentType, Double price, Integer numGuest,
			Pageable pageable);

	public Page<Apartment> findByApartmentType(ApartmentType apartmentType,
			Double price, Integer numGuest, Pageable pageable);

	public Page<Apartment> findAll(Double price, Integer numGuest,
			Pageable pageable);

	public Page<Apartment> findByBuilding(Building building, Double price,
			Integer numGuest, Pageable pageable);

	public Page<Apartment> findByCity(City city, Double price,
			Integer numGuest, Pageable pageable);
	
	public Apartment getRandomApartmentFromApartmentType(ApartmentType apartmentType);
	
	public List<Apartment> getAvailableApartment();
}
