package com.apartment.management.service.imp.building;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.interfaces.building.BuildingDaoInf;
import com.apartment.management.model.building.Building;
import com.apartment.management.repository.BuildingRepository;
import com.apartment.management.service.interfaces.building.BuildingService;

@Component
@Service
@Transactional
public class BuildingServiceImp implements BuildingService
{
	@Autowired
	private BuildingDaoInf apartmentDao;

	@Autowired
	private BuildingRepository apartmentRepository;

	@Override
	public void add(Building apartment)
	{
		apartmentDao.add(apartment);
	}

	@Override
	public void update(Building apartment)
	{
		apartmentDao.update(apartment);
	}

	@Override
	public void delete(Building apartment)
	{
		apartmentDao.delete(apartment);
	}

	@Override
	public List<Building> getAll()
	{
		return apartmentDao.getAll();
	}

	@Override
	public Page<Building> findAll(Pageable pageRequest)
	{
		return apartmentRepository.findAll(pageRequest);
	}

	@Override
	public Building getById(Short id)
	{
		return apartmentDao.getById(id);
	}
}
