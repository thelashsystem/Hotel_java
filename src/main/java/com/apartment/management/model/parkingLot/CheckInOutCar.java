package com.apartment.management.model.parkingLot;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.apartment.management.model.person.Guard;

@Entity
@Table(name = "Check_In_Out_Car")
public class CheckInOutCar implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(columnDefinition = "datetime")
	private Timestamp checkIn;
	@Column(columnDefinition = "datetime")
	private Timestamp checkOut;
	@ManyToOne(cascade = CascadeType.ALL)
	private Owner owner;
	@ManyToOne(cascade = CascadeType.ALL)
	private Guard guard;
	@ManyToOne(cascade = CascadeType.ALL)
	private ParkingLot parkingLot;

	public CheckInOutCar()
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

	public Timestamp getCheckIn()
	{
		return checkIn;
	}

	public void setCheckIn(Timestamp checkIn)
	{
		this.checkIn = checkIn;
	}

	public Timestamp getCheckOut()
	{
		return checkOut;
	}

	public void setCheckOut(Timestamp checkOut)
	{
		this.checkOut = checkOut;
	}

	public ParkingLot getParkingLot()
	{
		return parkingLot;
	}

	public void setParkingLot(ParkingLot parkingLot)
	{
		this.parkingLot = parkingLot;
	}

	public Owner getOwner()
	{
		return owner;
	}

	public void setOwner(Owner owner)
	{
		this.owner = owner;
	}

	public Guard getGuard()
	{
		return guard;
	}

	public void setGuard(Guard guard)
	{
		this.guard = guard;
	}

}
