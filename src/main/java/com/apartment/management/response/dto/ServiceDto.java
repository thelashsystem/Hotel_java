package com.apartment.management.response.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.apartment.management.model.building.Service;

public class ServiceDto implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Short id;
	private String name;
	private String partner;
	private String expiredDate;
	private Double currentPrice;
	private String status;

	public ServiceDto()
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

	public String getPartner()
	{
		return partner;
	}

	public void setPartner(String partner)
	{
		this.partner = partner;
	}

	public String getExpiredDate()
	{
		return expiredDate;
	}

	public void setExpiredDate(String expiredDate)
	{
		this.expiredDate = expiredDate;
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

	public static ServiceDto map(Service service)
	{
		ServiceDto serviceDto = new ServiceDto();
		serviceDto.setId(service.getId());
		serviceDto.setName(service.getName());
		//

		return serviceDto;
	}

	public static List<ServiceDto> map(List<Service> listService)
	{
		List<ServiceDto> listServiceDto = new ArrayList<>();
		for ( Service service : listService )
		{
			listServiceDto.add(map(service));
		}
		return listServiceDto;
	}
}
