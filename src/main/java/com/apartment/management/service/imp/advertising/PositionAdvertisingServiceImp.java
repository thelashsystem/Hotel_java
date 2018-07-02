package com.apartment.management.service.imp.advertising;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.interfaces.advertising.PositionAdvertisingDaoInf;
import com.apartment.management.model.advertising.PositionAdvertising;
import com.apartment.management.service.interfaces.advertising.PositionAdvertisingService;

@Component
@Service
@Transactional
public class PositionAdvertisingServiceImp implements
		PositionAdvertisingService
{
	@Autowired
	private PositionAdvertisingDaoInf positionAdvertisingDao;

	@Override
	public void add(PositionAdvertising positionAdvertising)
	{
		positionAdvertisingDao.add(positionAdvertising);
	}

	@Override
	public void update(PositionAdvertising positionAdvertising)
	{
		positionAdvertisingDao.update(positionAdvertising);
	}

	@Override
	public void delete(PositionAdvertising positionAdvertising)
	{
		positionAdvertisingDao.delete(positionAdvertising);
	}

	@Override
	public List<PositionAdvertising> getAll()
	{
		return positionAdvertisingDao.getAll();
	}

	@Override
	public PositionAdvertising getById(Short id)
	{
		return positionAdvertisingDao.getById(id);
	}

}
