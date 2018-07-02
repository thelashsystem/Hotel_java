package com.apartment.management.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apartment.management.model.building.Apartment;
import com.apartment.management.model.building.ApartmentType;
import com.apartment.management.model.building.Building;
import com.apartment.management.model.street.City;

public interface ApartmentRepository extends JpaRepository<Apartment, Integer>
{
	@Query(value = "select a from Apartment a where a.floor.building = :building and a.apartmentType = :apartmentType and a.apartmentType.price >= :price and maxNumGuest >= :numGuest ")
	public Page<Apartment> findByBuildingAndApartmentType(
			@Param(value = "building") Building building,
			@Param(value = "apartmentType") ApartmentType apartmentType,
			@Param(value = "price") Double price,
			@Param(value = "numGuest") Integer numGuest, Pageable pageable);

	@Query(value = "select a from Apartment a where a.floor.building.address.district.city = :city and a.apartmentType = :apartmentType and a.apartmentType.price >= :price and maxNumGuest >= :numGuest ")
	public Page<Apartment> findByCityAndApartmentType(
			@Param(value = "city") City city,
			@Param(value = "apartmentType") ApartmentType apartmentType,
			@Param(value = "price") Double price,
			@Param(value = "numGuest") Integer numGuest, Pageable pageable);

	@Query(value = "select a from Apartment a where a.apartmentType = :apartmentType and a.apartmentType.price >= :price and maxNumGuest >= :numGuest ")
	public Page<Apartment> findByApartmentType(
			@Param(value = "apartmentType") ApartmentType apartmentType,
			@Param(value = "price") Double price,
			@Param(value = "numGuest") Integer numGuest, Pageable pageable);

	@Query(value = "select a from Apartment a where a.floor.building = :building and a.apartmentType.price >= :price and maxNumGuest >= :numGuest ")
	public Page<Apartment> findByBuilding(
			@Param(value = "building") Building building,
			@Param(value = "price") Double price,
			@Param(value = "numGuest") Integer numGuest, Pageable pageable);

	@Query(value = "select a from Apartment a where a.apartmentType.price > :price and maxNumGuest >= :numGuest ")
	public Page<Apartment> findAll(@Param(value = "price") Double price,
			@Param(value = "numGuest") Integer numGuest, Pageable pageable);

	@Query(value = "select a from Apartment a where a.floor.building.address.district.city = :city and a.apartmentType.price > :price and maxNumGuest >= :numGuest ")
	public Page<Apartment> findByCity(@Param(value = "city") City city,
			@Param(value = "price") Double price,
			@Param(value = "numGuest") Integer numGuest, Pageable pageable);
}
