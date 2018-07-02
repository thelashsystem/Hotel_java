package com.apartment.management.service.imp.advertising;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.interfaces.advertising.AdvertisingDaoInf;
import com.apartment.management.model.advertising.Advertising;
import com.apartment.management.service.interfaces.advertising.AdvertisingService;

@Component
@Service
@Transactional
public class AdvertisingServiceImp implements AdvertisingService
{
	@Autowired
	private AdvertisingDaoInf advertisingDao;

	@Override
	public void add(Advertising advertising)
	{
		advertisingDao.add(advertising);
	}

	@Override
	public void update(Advertising advertising)
	{
		advertisingDao.update(advertising);
	}

	@Override
	public void delete(Advertising advertising)
	{
		advertisingDao.delete(advertising);
	}

	@Override
	public List<Advertising> getAll()
	{
		return advertisingDao.getAll();
	}

	@Override
	public Advertising getById(Integer id)
	{
		return advertisingDao.getById(id);
	}

}
