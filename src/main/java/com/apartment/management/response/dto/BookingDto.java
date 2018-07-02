package com.apartment.management.response.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.apartment.management.model.business.BookingApartment;

public class BookingDto
{
	private Long id;
	private String bookingDate;
	private String fullName;
	private String checkInDate;
	private String apartment;
	private String status;
	@Autowired
	@Qualifier("dateFormat_MMddyyyy_hhmm")
	private SimpleDateFormat dateFormat;

	public BookingDto()
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

	public String getBookingDate()
	{
		return bookingDate;
	}

	public void setBookingDate(Timestamp bookingDate)
	{
		this.bookingDate = dateFormat.format(bookingDate);
	}

	public String getFullName()
	{
		return fullName;
	}

	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}

	public String getCheckInDate()
	{
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate)
	{
		this.checkInDate = dateFormat.format(checkInDate);
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getApartment()
	{
		return apartment;
	}

	public void setApartment(String apartment)
	{
		this.apartment = apartment;
	}

	public void setBookingDate(String bookingDate)
	{
		this.bookingDate = bookingDate;
	}

	public void setCheckInDate(String checkInDate)
	{
		this.checkInDate = checkInDate;
	}

	public static BookingDto map(BookingApartment bookingRoom)
	{
		BookingDto bookingDto = new BookingDto();
		bookingDto.setId(bookingRoom.getId());
		bookingDto.setFullName(bookingRoom.getCustomer().getProfile()
				.getLastName()
				+ " " + bookingRoom.getCustomer().getProfile().getFirstName());
		bookingDto.setCheckInDate(bookingRoom.getCheckin());
		bookingDto.setBookingDate(bookingRoom.getBookingDate());
		bookingDto.setApartment(bookingRoom.getApartment() != null ? bookingRoom.getApartment().getName() : "");

		return bookingDto;
	}

	public static List<BookingDto> map(List<BookingApartment> listBookingRoom)
	{
		List<BookingDto> listBookingDto = new ArrayList<>();
		for ( BookingApartment booking : listBookingRoom )
		{
			listBookingDto.add(map(booking));
		}
		return listBookingDto;
	}
}
