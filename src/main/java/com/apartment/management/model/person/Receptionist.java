package com.apartment.management.model.person;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.apartment.management.model.business.BookingApartment;

@Entity
public class Receptionist extends Employee
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "receptionist", cascade = CascadeType.ALL)
	private Set<BookingApartment> bookingRoom;

	public Receptionist()
	{
	}

	public Set<BookingApartment> getBookingRoom()
	{
		return bookingRoom;
	}

	public void setBookingRoom(Set<BookingApartment> bookingRoom)
	{
		this.bookingRoom = bookingRoom;
	}

	@Override
	public String toString()
	{
		return "Receptionist";
	}

	
}
