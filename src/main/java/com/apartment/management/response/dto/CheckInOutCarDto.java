package com.apartment.management.response.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.apartment.management.model.parkingLot.CheckInOutCar;

public class CheckInOutCarDto
{
	private Long id;
	private String checkIn;
	private String checkOut;
	private String status;
	private String guard;
	private String owner;
	private String parkingLot;
	@Autowired
	@Qualifier("dateFormat_MMddyyyy_hhmm")
	private static SimpleDateFormat dateFormat;

	public CheckInOutCarDto()
	{
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getCheckIn()
	{
		return checkIn;
	}

	public void setCheckIn(Timestamp checkIn)
	{
		this.checkIn = dateFormat.format(checkIn);
	}

	public String getCheckOut()
	{
		return checkOut;
	}

	public void setCheckOut(Timestamp checkOut)
	{
		this.checkOut = dateFormat.format(checkOut);
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getGuard()
	{
		return guard;
	}

	public void setGuard(String guard)
	{
		this.guard = guard;
	}

	public String getOwner()
	{
		return owner;
	}

	public void setOwner(String owner)
	{
		this.owner = owner;
	}

	public String getParkingLot()
	{
		return parkingLot;
	}

	public void setParkingLot(String parkingLot)
	{
		this.parkingLot = parkingLot;
	}

	public static CheckInOutCarDto map(CheckInOutCar checkInOutCar)
	{
		CheckInOutCarDto checkInOutCarDto = new CheckInOutCarDto();
		checkInOutCarDto.setId(checkInOutCar.getId());
		if ( checkInOutCar.getOwner().getCustomer() != null )
		{
			checkInOutCarDto.setOwner(checkInOutCar.getOwner().getCustomer()
					.getProfile().getLastName()
					+ " "
					+ checkInOutCar.getOwner().getCustomer().getProfile()
							.getFirstName());
		} else
		{
			checkInOutCarDto.setOwner(checkInOutCar.getOwner().getEmployee()
					.getProfile().getLastName()
					+ " "
					+ checkInOutCar.getOwner().getEmployee().getProfile()
							.getFirstName());
		}
		checkInOutCarDto.setCheckIn(checkInOutCar.getCheckIn());
		checkInOutCarDto.setCheckOut(checkInOutCar.getCheckOut());
		checkInOutCarDto.setGuard(checkInOutCar.getGuard().getProfile()
				.getLastName()
				+ " " + checkInOutCar.getGuard().getProfile().getFirstName());
		checkInOutCarDto.setParkingLot(checkInOutCar.getParkingLot().getName());
		return checkInOutCarDto;
	}

	public static List<CheckInOutCarDto> map(
			List<CheckInOutCar> listCheckInOutCar)
	{
		List<CheckInOutCarDto> listCheckInOutCarDto = new ArrayList<>();
		for ( CheckInOutCar checkInOutCar : listCheckInOutCar )
		{
			listCheckInOutCarDto.add(map(checkInOutCar));
		}
		return listCheckInOutCarDto;
	}

}
