package com.apartment.management.model.person;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.apartment.management.model.account.CustomerAccount;
import com.apartment.management.model.business.BookingApartment;
import com.apartment.management.model.parkingLot.Owner;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Customer")
public class Customer extends Person
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Owner> transport;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<CustomerAccount> account;
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	private Set<BookingApartment> bookingRooms;

	public Customer()
	{
	}

	@JsonIgnore
	public Set<Owner> getTransport()
	{
		return transport;
	}

	public void setTransport(Set<Owner> transport)
	{
		this.transport = transport;
	}

	public Set<CustomerAccount> getAccount()
	{
		return account;
	}

	public void setAccount(Set<CustomerAccount> account)
	{
		this.account = account;
	}

	public Set<BookingApartment> getBookingRooms()
	{
		return bookingRooms;
	}

	public void setBookingRooms(Set<BookingApartment> bookingRooms)
	{
		this.bookingRooms = bookingRooms;
	}

}
