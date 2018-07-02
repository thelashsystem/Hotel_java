package com.apartment.management.service.imp.building;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.interfaces.building.ApartmentDaoInf;
import com.apartment.management.model.building.Apartment;
import com.apartment.management.model.building.ApartmentType;
import com.apartment.management.model.building.Building;
import com.apartment.management.model.street.City;
import com.apartment.management.repository.ApartmentRepository;
import com.apartment.management.service.interfaces.building.ApartmentService;

@Component
@Service
@Transactional
public class ApartmentServiceImp implements ApartmentService
{
	@Autowired
	private ApartmentDaoInf apartmentDao;

	@Autowired
	private ApartmentRepository apartmentRepository;

	@Override
	public void add(Apartment room)
	{
		apartmentDao.add(room);
	}

	@Override
	public void update(Apartment room)
	{
		apartmentDao.update(room);
	}

	@Override
	public void delete(Apartment room)
	{
		apartmentDao.delete(room);
	}

	@Override
	public List<Apartment> getAllApartment()
	{
		return apartmentDao.getAll();
	}

	@Override
	public List<Apartment> getAll()
	{
		return apartmentDao.getAll();
	}

	@Override
	public Apartment getById(Integer id)
	{
		return apartmentDao.getById(id);
	}

	@Override
	public List<Apartment> get3PopularApartmentFromApartmentType(
			ApartmentType apartmentType)
	{
		return apartmentDao
				.get3PopularApartmentFromApartmentType(apartmentType);
	}

	@Override
	public List<Apartment> get3RandomApartmentFromApartmentType(
			ApartmentType apartmentType)
	{
		return apartmentDao.get3RandomApartmentFromApartmentType(apartmentType);
	}

	@Override
	public Page<Apartment> findByBuildingAndApartmentType(Building building,
			ApartmentType apartmentType, Double price, Integer numGuest,
			Pageable pageable)
	{
		return apartmentRepository.findByBuildingAndApartmentType(building,
				apartmentType, price, numGuest, pageable);
	}

	@Override
	public Page<Apartment> findByCityAndApartmentType(City city,
			ApartmentType apartmentType, Double price, Integer numGuest,
			Pageable pageable)
	{
		return apartmentRepository.findByCityAndApartmentType(city,
				apartmentType, price, numGuest, pageable);
	}

	@Override
	public Page<Apartment> findAll(Double price, Integer numGuest, Pageable pageable)
	{
		return apartmentRepository.findAll(price, numGuest, pageable);
	}

	@Override
	public Page<Apartment> findByApartmentType(ApartmentType apartmentType,
			Double price, Integer numGuest, Pageable pageable)
	{
		return apartmentRepository.findByApartmentType(apartmentType, price,
				numGuest, pageable);
	}

	@Override
	public Page<Apartment> findByBuilding(Building building, Double price,
			Integer numGuest, Pageable pageable)
	{
		return apartmentRepository.findByBuilding(building, price, numGuest,
				pageable);
	}

	@Override
	public Page<Apartment> findByCity(City city, Double price,
			Integer numGuest, Pageable pageable)
	{
		return apartmentRepository.findByCity(city, price, numGuest, pageable);
	}

	@Override
	public Apartment getRandomApartmentFromApartmentType(
			ApartmentType apartmentType)
	{
		return apartmentDao.getRandomApartmentFromApartmentType(apartmentType);
	}

	@Override
	public List<Apartment> getAvailableApartment()
	{
		return apartmentDao.getAvailableApartment();
	}
}
