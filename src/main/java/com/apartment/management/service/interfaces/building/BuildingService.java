package com.apartment.management.service.interfaces.building;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.apartment.management.model.building.Building;
import com.apartment.management.service.interfaces.GeneralService;

public interface BuildingService extends GeneralService<Building, Short>
{
	public Page<Building> findAll(Pageable pageRequest);
}
