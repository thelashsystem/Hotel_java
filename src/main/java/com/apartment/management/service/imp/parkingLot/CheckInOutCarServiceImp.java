package com.apartment.management.service.imp.parkingLot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.imp.parkingLot.CheckInOutCarDao;
import com.apartment.management.model.parkingLot.CheckInOutCar;
import com.apartment.management.service.interfaces.parkingLot.CheckInOutCarService;

@Component
@Service
@Transactional
public class CheckInOutCarServiceImp implements CheckInOutCarService
{
	@Autowired
	private CheckInOutCarDao checkInOutCarDao;

	@Override
	public void add(CheckInOutCar checkInOutCar)
	{
		checkInOutCarDao.add(checkInOutCar);
	}

	@Override
	public void update(CheckInOutCar checkInOutCar)
	{
		checkInOutCarDao.update(checkInOutCar);
	}

	@Override
	public void delete(CheckInOutCar checkInOutCar)
	{
		checkInOutCarDao.delete(checkInOutCar);
	}

	@Override
	public List<CheckInOutCar> getAll()
	{
		return checkInOutCarDao.getAll();
	}

	@Override
	public CheckInOutCar getById(Long id)
	{
		return checkInOutCarDao.getById(id);
	}

}
