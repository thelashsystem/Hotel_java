package com.apartment.management.response.dto;

import java.util.ArrayList;
import java.util.List;

import com.apartment.management.model.building.Building;
import com.apartment.management.model.parkingLot.ParkingLot;

public class ParkingLotDto
{
	private Short id;
	private Building building;
	private String name;
	private Integer capacity;
	private String status;

	public ParkingLotDto()
	{
	}

	public Short getId()
	{
		return id;
	}

	public void setId(Short id)
	{
		this.id = id;
	}

	public Building getBuilding()
	{
		return building;
	}

	public void setBuilding(Building building)
	{
		this.building = building;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getCapacity()
	{
		return capacity;
	}

	public void setCapacity(Integer capacity)
	{
		this.capacity = capacity;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public static ParkingLotDto map(ParkingLot parkingLot)
	{
		ParkingLotDto parkingLotDto = new ParkingLotDto();
		parkingLotDto.setId(parkingLot.getId());
		parkingLotDto.setName(parkingLot.getName());
		parkingLotDto.setCapacity(parkingLot.getCapacity());
		parkingLotDto.setBuilding(parkingLot.getBuilding());

		return parkingLotDto;
	}

	public static List<ParkingLotDto> map(List<ParkingLot> parkingLots)
	{
		List<ParkingLotDto> parkingLotDtos = new ArrayList<>();
		for ( ParkingLot parkingLot : parkingLots )
		{
			parkingLotDtos.add(map(parkingLot));
		}
		return parkingLotDtos;
	}
}
