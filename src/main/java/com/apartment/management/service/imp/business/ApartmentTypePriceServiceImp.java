package com.apartment.management.service.imp.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.interfaces.business.ApartmentTypePriceDaoInf;
import com.apartment.management.model.building.ApartmentType;
import com.apartment.management.model.business.ApartmentTypePrice;
import com.apartment.management.service.interfaces.business.ApartmentTypePriceService;

@Component
@Service
@Transactional
public class ApartmentTypePriceServiceImp implements ApartmentTypePriceService
{
	@Autowired
	private ApartmentTypePriceDaoInf apartmentTypePriceDao;

	@Override
	public void add(ApartmentTypePrice apartmentTypePrice)
	{
		apartmentTypePriceDao.add(apartmentTypePrice);
	}

	@Override
	public void update(ApartmentTypePrice apartmentTypePrice)
	{
		apartmentTypePriceDao.update(apartmentTypePrice);
	}

	@Override
	public void delete(ApartmentTypePrice apartmentTypePrice)
	{
		apartmentTypePriceDao.delete(apartmentTypePrice);
	}

	@Override
	public List<ApartmentTypePrice> getAll()
	{
		return apartmentTypePriceDao.getAll();
	}

	@Override
	public ApartmentTypePrice getById(Integer id)
	{
		return apartmentTypePriceDao.getById(id);
	}

	@Override
	public ApartmentTypePrice getLastestApartmentTypePrice(
			ApartmentType apartmentType)
	{
		return apartmentTypePriceDao
				.getLastestApartmentTypePrice(apartmentType);
	}

}
