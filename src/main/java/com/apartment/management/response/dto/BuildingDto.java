package com.apartment.management.response.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import com.apartment.management.model.building.Building;
import com.apartment.management.model.building.Floor;

public class BuildingDto implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Short id;
	private String name;
	private String address;
	private String phone;
	private Byte numberFloor;
	private Short numberEmployee;
	private Short numberApartment;

	public BuildingDto()
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

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public Byte getNumberFloor()
	{
		return numberFloor;
	}

	public void setNumberFloor(Byte numberFloor)
	{
		this.numberFloor = numberFloor;
	}

	public Short getNumberEmployee()
	{
		return numberEmployee;
	}

	public void setNumberEmployee(Short numberEmployee)
	{
		this.numberEmployee = numberEmployee;
	}

	public Short getNumberApartment()
	{
		return numberApartment;
	}

	public void setNumberApartment(Short numberApartment)
	{
		this.numberApartment = numberApartment;
	}

	public static BuildingDto map(Building building)
	{
		BuildingDto buildingDto = new BuildingDto();
		buildingDto.setId(building.getId());
		buildingDto.setName(building.getName());
		buildingDto.setPhone(building.getPhone());
		buildingDto.setNumberFloor((byte) building.getFloors().size());
		buildingDto.setNumberEmployee((short) building.getAssignment().size());
		short numberApartment = 0;
		for (Floor floor: building.getFloors()) {
			numberApartment += floor.getApartment().size();
		}
		buildingDto.setNumberApartment(numberApartment);
		return buildingDto;
	}

	public static List<BuildingDto> map(Page<Building> listBuilding)
	{
		List<BuildingDto> listBuildingDto = new ArrayList<>();
		for ( Building building : listBuilding )
		{
			listBuildingDto.add(map(building));
		}
		return listBuildingDto;
	}

	public static List<BuildingDto> map(List<Building> listBuilding)
	{
		List<BuildingDto> listBuildingDto = new ArrayList<>();
		for ( Building building : listBuilding )
		{
			listBuildingDto.add(map(building));
		}
		return listBuildingDto;
	}

}
