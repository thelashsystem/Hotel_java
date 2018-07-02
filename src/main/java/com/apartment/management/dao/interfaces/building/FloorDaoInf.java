package com.apartment.management.dao.interfaces.building;

import java.util.List;

import com.apartment.management.dao.interfaces.GeneralDao;
import com.apartment.management.model.building.Building;
import com.apartment.management.model.building.Floor;

public interface FloorDaoInf extends GeneralDao<Floor, Integer>
{
	public Byte countNumFloorInBuilding(Building building);
	
	public List<Floor> getFloorByBuilding(Building building);
}
