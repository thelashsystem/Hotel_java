package com.apartment.management.model.business;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.apartment.management.model.person.PersonalProfile;

@Entity
@Table(name = "Guest")
public class Guest implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne(cascade = CascadeType.ALL)
	private BookingApartment bookingApartment;
	@Embedded
	private PersonalProfile personalProfile;

	public Guest()
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

	public BookingApartment getBookingApartment()
	{
		return bookingApartment;
	}

	public void setBookingApartment(BookingApartment bookingApartment)
	{
		this.bookingApartment = bookingApartment;
	}

	public PersonalProfile getPersonalProfile()
	{
		return personalProfile;
	}

	public void setPersonalProfile(PersonalProfile personalProfile)
	{
		this.personalProfile = personalProfile;
	}

}
