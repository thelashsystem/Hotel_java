package com.apartment.management.response.dto;

import java.util.ArrayList;
import java.util.List;

import com.apartment.management.model.building.Floor;

public class FloorDto
{
	private Integer id;
	private String name;
	private Integer numberApartment;
	private Integer numberAvailableApartment;
	private Double occupationRate;

	public FloorDto()
	{
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getNumberApartment()
	{
		return numberApartment;
	}

	public void setNumberApartment(Integer numberApartment)
	{
		this.numberApartment = numberApartment;
	}

	public Integer getNumberAvailableApartment()
	{
		return numberAvailableApartment;
	}

	public void setNumberAvailableApartment(Integer numberAvailableApartment)
	{
		this.numberAvailableApartment = numberAvailableApartment;
	}

	public Double getOccupationRate()
	{
		return occupationRate;
	}

	public void setOccupationRate(Double occupationRate)
	{
		this.occupationRate = occupationRate;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public static FloorDto map(Floor floor) {
		FloorDto floorDto = new FloorDto();
		floorDto.setId(floor.getId());
		floorDto.setName(floor.getFloorGroup().getName());
		floorDto.setNumberApartment(floor.getApartment().size());
		
		return floorDto;
	}
	
	public static List<FloorDto> map(List<Floor> floors) {
		List<FloorDto> listFloorDto = new ArrayList<>();
		for (Floor floor: floors) {
			listFloorDto.add(map(floor));
		}
		return listFloorDto;
	}
}
