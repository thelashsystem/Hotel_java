package com.apartment.management.service.imp.building;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.interfaces.building.FloorDaoInf;
import com.apartment.management.model.building.Building;
import com.apartment.management.model.building.Floor;
import com.apartment.management.service.interfaces.building.FloorService;

@Component
@Service
@Transactional
public class FloorServiceImp implements FloorService
{
	@Autowired
	private FloorDaoInf floorDao;

	@Override
	public void add(Floor floor)
	{
		floorDao.add(floor);
	}

	@Override
	public void update(Floor floor)
	{
		floorDao.update(floor);
	}

	@Override
	public void delete(Floor floor)
	{
		floorDao.delete(floor);
	}

	@Override
	public List<Floor> getAll()
	{
		return floorDao.getAll();
	}

	@Override
	public Floor getById(Integer id)
	{
		return floorDao.getById(id);
	}

	@Override
	public Byte countNumFloorInBuilding(Building building)
	{
		System.out.println(building.getName());
		return floorDao.countNumFloorInBuilding(building);
	}

	@Override
	public List<Floor> getFloorByBuilding(Building building)
	{
		return floorDao.getFloorByBuilding(building);
	}
}
