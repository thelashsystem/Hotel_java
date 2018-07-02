package com.apartment.management.service.imp.building;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.interfaces.building.CriteriaApartmentTypeDaoInf;
import com.apartment.management.model.building.CriteriaApartmentType;
import com.apartment.management.service.interfaces.building.CriteriaApartmentTypeService;

@Component
@Service
@Transactional
public class CriteriaRoomTypeServiceImp implements CriteriaApartmentTypeService
{
	@Autowired
	private CriteriaApartmentTypeDaoInf criteriaRoomTypeDao;

	@Override
	public void add(CriteriaApartmentType criteriaRoomType)
	{
		criteriaRoomTypeDao.add(criteriaRoomType);
	}

	@Override
	public void update(CriteriaApartmentType criteriaRoomType)
	{
		criteriaRoomTypeDao.add(criteriaRoomType);
	}

	@Override
	public void delete(CriteriaApartmentType criteriaRoomType)
	{
		criteriaRoomTypeDao.delete(criteriaRoomType);
	}

	@Override
	public List<CriteriaApartmentType> getAll()
	{
		return criteriaRoomTypeDao.getAll();
	}

	@Override
	public CriteriaApartmentType getById(Short id)
	{
		return criteriaRoomTypeDao.getById(id);
	}
}
