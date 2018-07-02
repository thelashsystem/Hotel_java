package com.apartment.management.service.imp.street;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.imp.street.DistrictDao;
import com.apartment.management.model.street.City;
import com.apartment.management.model.street.District;
import com.apartment.management.service.interfaces.street.DistrictService;

@Component
@Service
@Transactional
public class DistrictServiceImp implements DistrictService
{
	@Autowired
	private DistrictDao DistrictDao;

	@Override
	public void add(District district)
	{
		DistrictDao.add(district);
	}

	@Override
	public void update(District district)
	{
		DistrictDao.update(district);
	}

	@Override
	public void delete(District district)
	{
		DistrictDao.delete(district);
	}

	@Override
	public List<District> getAll()
	{
		return DistrictDao.getAll();
	}

	@Override
	public List<District> getDistrictByCity(City city)
	{
		return DistrictDao.getDistrictByCity(city);
	}

	@Override
	public District getById(Short id)
	{
		return DistrictDao.getById(id);
	}
}
