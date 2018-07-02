package com.apartment.management.service.imp.parkingLot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.imp.parkingLot.ParkingLotDao;
import com.apartment.management.model.parkingLot.ParkingLot;
import com.apartment.management.service.interfaces.parkingLot.ParkingLotService;

@Component
@Service
@Transactional
public class ParkingLotServiceImp implements ParkingLotService
{
	@Autowired
	private ParkingLotDao parkingLotDao;

	@Override
	public void add(ParkingLot parkingLot)
	{
		parkingLotDao.add(parkingLot);
	}

	@Override
	public void update(ParkingLot parkingLot)
	{
		parkingLotDao.update(parkingLot);
	}

	@Override
	public void delete(ParkingLot parkingLot)
	{
		parkingLotDao.delete(parkingLot);
	}

	@Override
	public List<ParkingLot> getAll()
	{
		return parkingLotDao.getAll();
	}

	@Override
	public ParkingLot getById(Short id)
	{
		return parkingLotDao.getById(id);
	}

}
