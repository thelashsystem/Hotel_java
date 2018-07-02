package com.apartment.management.service.imp.building;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.interfaces.building.ApartmentTypeDaoInf;
import com.apartment.management.model.building.ApartmentType;
import com.apartment.management.service.interfaces.building.ApartmentTypeService;

@Component
@Service
@Transactional
public class ApartmentTypeServiceImp implements ApartmentTypeService
{
	@Autowired
	private ApartmentTypeDaoInf apartmentTypeDao;

	@Override
	public void add(ApartmentType roomType)
	{
		apartmentTypeDao.add(roomType);
	}

	@Override
	public void update(ApartmentType roomType)
	{
		apartmentTypeDao.update(roomType);
	}

	@Override
	public void delete(ApartmentType roomType)
	{
		apartmentTypeDao.delete(roomType);
	}

	@Override
	public List<ApartmentType> getAllApartmentType()
	{
		return apartmentTypeDao.getAll();
	}

	@Override
	public ApartmentType getById(Short id)
	{
		return apartmentTypeDao.getById(id);
	}

	@Override
	public ApartmentType getApartmentTypeByCode(String code)
	{
		return apartmentTypeDao.getApartmentTypeByCode(code);
	}

	@Override
	public List<ApartmentType> getAll()
	{
		return apartmentTypeDao.getAll();
	}

	@Override
	public List<ApartmentType> get3HighestApartmentType()
	{
		return apartmentTypeDao.get3HighestApartmentType();
	}


}
