package com.apartment.management.response.dto;

import java.util.ArrayList;
import java.util.List;

import com.apartment.management.model.building.ApartmentType;

public class ApartmentTypeDto
{
	private Short id;
	private String name;
	private Double currentPrice;
	private Integer numberRoom;
	private Integer numberAvailableRoom;
	private String status;
	private String description;

	public ApartmentTypeDto()
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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Double getCurrentPrice()
	{
		return currentPrice;
	}

	public void setCurrentPrice(Double currentPrice)
	{
		this.currentPrice = currentPrice;
	}

	public Integer getNumberRoom()
	{
		return numberRoom;
	}

	public void setNumberRoom(Integer numberRoom)
	{
		this.numberRoom = numberRoom;
	}

	public Integer getNumberAvailableRoom()
	{
		return numberAvailableRoom;
	}

	public void setNumberAvailableRoom(Integer numberAvailableRoom)
	{
		this.numberAvailableRoom = numberAvailableRoom;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public static ApartmentTypeDto map(ApartmentType apartmentType)
	{
		ApartmentTypeDto apartmentTypeDto = new ApartmentTypeDto();
		apartmentTypeDto.setId(apartmentType.getId());
		apartmentTypeDto.setName(apartmentType.getName());
		apartmentTypeDto.setDescription(apartmentType.getDescription());

		return apartmentTypeDto;
	}

	public static List<ApartmentTypeDto> map(
			List<ApartmentType> listApartmentType)
	{
		List<ApartmentTypeDto> listApartmentTypeDto = new ArrayList<>();
		for ( ApartmentType apartmentType : listApartmentType )
		{
			listApartmentTypeDto.add(map(apartmentType));
		}
		return listApartmentTypeDto;
	}

}
