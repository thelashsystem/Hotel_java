package com.apartment.management.service.interfaces.building;

import java.util.List;

import com.apartment.management.model.building.Building;
import com.apartment.management.model.building.Floor;
import com.apartment.management.service.interfaces.GeneralService;

public interface FloorService extends GeneralService<Floor, Integer>
{
	public Byte countNumFloorInBuilding(Building building);
	
	public List<Floor> getFloorByBuilding(Building building);
}
