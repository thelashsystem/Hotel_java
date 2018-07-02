package com.apartment.management.service.imp.asset;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.interfaces.asset.ApartmentEquipmentDaoInf;
import com.apartment.management.model.asset.ApartmentEquipment;
import com.apartment.management.model.building.Apartment;
import com.apartment.management.service.interfaces.asset.ApartmentEquipmentService;

@Component
@Service
@Transactional
public class ApartmentEquipmentServiceImp implements ApartmentEquipmentService
{
	@Autowired
	private ApartmentEquipmentDaoInf apartmentEquipmentDao;

	@Override
	public void add(ApartmentEquipment apartmentEquipment)
	{
		apartmentEquipmentDao.add(apartmentEquipment);
	}

	@Override
	public void update(ApartmentEquipment apartmentEquipment)
	{
		apartmentEquipmentDao.update(apartmentEquipment);
	}

	@Override
	public void delete(ApartmentEquipment apartmentEquipment)
	{
		apartmentEquipmentDao.delete(apartmentEquipment);
	}

	@Override
	public List<ApartmentEquipment> getAll()
	{
		return apartmentEquipmentDao.getAll();
	}

	@Override
	public ApartmentEquipment getById(Integer id)
	{
		return apartmentEquipmentDao.getById(id);
	}

	@Override
	public List<ApartmentEquipment> getUnhiddenEquipmentInApartment(
			Apartment apartment)
	{
		return apartmentEquipmentDao.getUnhiddenEquipmentInApartment(apartment);
	}

	@Override
	public List<ApartmentEquipment> getAllEquipmentInApartment(
			Apartment apartment)
	{
		return apartmentEquipmentDao.getAllEquipmentInApartment(apartment);
	}

}
