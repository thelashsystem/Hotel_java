package com.apartment.management.response.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.apartment.management.model.building.Apartment;
import com.apartment.management.model.building.ApartmentType;
import com.apartment.management.model.building.Building;

public class ApartmentDto implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String floor;
	private Building building;
	private String status;
	private ApartmentType apartmentType;

	public ApartmentDto()
	{
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getFloor()
	{
		return floor;
	}

	public void setFloor(String floor)
	{
		this.floor = floor;
	}

	public Building getBuilding()
	{
		return building;
	}

	public void setBuilding(Building building)
	{
		this.building = building;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public ApartmentType getApartmentType()
	{
		return apartmentType;
	}

	public void setApartmentType(ApartmentType apartmentType)
	{
		this.apartmentType = apartmentType;
	}

	public static ApartmentDto map(Apartment apartment)
	{
		ApartmentDto apartmentDto = new ApartmentDto();
		apartmentDto.setId(apartment.getId());
		apartmentDto.setName(apartment.getName());
		apartmentDto.setFloor(apartment.getFloor().getFloorGroup().getName());
		apartmentDto.setBuilding(apartment.getFloor().getBuilding());
		apartmentDto.setApartmentType(apartment.getApartmentType());
		apartmentDto.setStatus(apartment.getStatus());
		return apartmentDto;
	}

	public static List<ApartmentDto> map(List<Apartment> listApartment)
	{
		List<ApartmentDto> listApartmentDto = new ArrayList<>();
		for ( Apartment apartment : listApartment )
		{
			listApartmentDto.add(map(apartment));
		}
		return listApartmentDto;
	}

}
