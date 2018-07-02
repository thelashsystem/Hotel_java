package com.apartment.management.response;


import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class BookingRequest
{
	private Integer apartmentId;
	private String email;
	private Date checkIn;
	private Date checkOut;
	private Integer numGuest;

	public BookingRequest()
	{
	}

	public Integer getApartmentId()
	{
		return apartmentId;
	}

	public void setApartmentId(Integer apartmentId)
	{
		this.apartmentId = apartmentId;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Date getCheckIn()
	{
		return checkIn;
	}

	public void setCheckIn(Date checkIn)
	{
		this.checkIn = checkIn;
	}

	public Date getCheckOut()
	{
		return checkOut;
	}

	public void setCheckOut(Date checkOut)
	{
		this.checkOut = checkOut;
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
