package com.apartment.management.response.dto;

import java.util.ArrayList;
import java.util.List;

import com.apartment.management.model.business.Resource;

public class ResourceDto
{
	private Short id;
	private String name;
	private String updatedDate;
	private String measure;
	private Double currentPrice;
	private String status;

	public ResourceDto()
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

	public String getUpdatedDate()
	{
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate)
	{
		this.updatedDate = updatedDate;
	}

	public String getMeasure()
	{
		return measure;
	}

	public void setMeasure(String measure)
	{
		this.measure = measure;
	}

	public Double getCurrentPrice()
	{
		return currentPrice;
	}

	public void setCurrentPrice(Double currentPrice)
	{
		this.currentPrice = currentPrice;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public static ResourceDto map(Resource resource)
	{
		ResourceDto resourceDto = new ResourceDto();
		resourceDto.setId(resource.getId());
		resourceDto.setName(resource.getName());
		//

		return resourceDto;
	}

	public static List<ResourceDto> map(List<Resource> resources)
	{
		List<ResourceDto> listResourceDto = new ArrayList<>();
		for ( Resource resource : resources )
		{
			listResourceDto.add(map(resource));
		}
		return listResourceDto;
	}

}
