package com.apartment.management.response;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class SearchRequest
{
	private Short cityId;
	private Short buildingId;
	private Short apartmentTypeId;
	private Date checkIn;
	private Integer priceSort;
	private Double priceRange;
	private Integer numGuest;

	public SearchRequest()
	{
		priceSort = 0;
		priceRange = 100.0;
	}

	public Short getCityId()
	{
		return cityId;
	}

	public void setCityId(Short cityId)
	{
		this.cityId = cityId;
	}

	public Short getBuildingId()
	{
		return buildingId;
	}

	public void setBuildingId(Short buildingId)
	{
		this.buildingId = buildingId;
	}

	public Short getApartmentTypeId()
	{
		return apartmentTypeId;
	}

	public void setApartmentTypeId(Short apartmentTypeId)
	{
		this.apartmentTypeId = apartmentTypeId;
	}

	public Date getCheckIn()
	{
		return checkIn;
	}

	public void setCheckIn(Date checkIn)
	{
		this.checkIn = checkIn;
	}

	public Integer getPriceSort()
	{
		return priceSort;
	}

	public void setPriceSort(Integer priceSort)
	{
		this.priceSort = priceSort;
	}

	public Double getPriceRange()
	{
		return priceRange;
	}

	public void setPriceRange(Double priceRange)
	{
		this.priceRange = priceRange;
	}

	public Integer getNumGuest()
	{
		return numGuest;
	}

	public void setNumGuest(Integer numGuest)
	{
		this.numGuest = numGuest;
	}

}
