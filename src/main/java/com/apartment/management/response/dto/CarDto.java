package com.apartment.management.response.dto;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.apartment.management.model.parkingLot.Transport;

public class CarDto
{
	private Integer id;
	private String owner;
	private String type;
	private String createdDate;
	private String status;
	@Autowired
	@Qualifier("dateFormat_MMddyyyy")
	private SimpleDateFormat dateFormat;

	public CarDto()
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

	public String getOwner()
	{
		return owner;
	}

	public void setOwner(String owner)
	{
		this.owner = owner;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = dateFormat.format(createdDate);
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public static CarDto map(Transport transport)
	{
		CarDto carDto = new CarDto();
		carDto.setId(transport.getId());

		return carDto;
	}

	public static List<CarDto> map(List<Transport> listTransport)
	{
		List<CarDto> carDtos = new ArrayList<>();
		for ( Transport transport : listTransport )
		{
			carDtos.add(map(transport));
		}
		return carDtos;
	}

}
