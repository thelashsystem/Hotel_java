package com.apartment.management.service.imp.street;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.imp.street.CityDao;
import com.apartment.management.model.street.City;
import com.apartment.management.service.interfaces.street.CityService;

@Component
@Service
@Transactional
public class CityServiceImp implements CityService
{
	@Autowired
	private CityDao cityDao;

	@Override
	public void add(City city)
	{
		cityDao.add(city);
	}

	@Override
	public void update(City city)
	{
		cityDao.update(city);
	}

	@Override
	public void delete(City city)
	{
		cityDao.delete(city);
	}

	@Override
	public List<City> getAll()
	{
		return cityDao.getAll();
	}

	@Override
	public City getById(Short id)
	{
		return cityDao.getById(id);
	}

}
