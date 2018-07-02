package com.apartment.management.model.person;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.apartment.management.model.parkingLot.CheckInOutCar;

@Entity
public class Guard extends Employee
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "guard")
	private Set<CheckInOutCar> checkInOutCar;

	public Guard()
	{
	}

	public Set<CheckInOutCar> getCheckInOutCar()
	{
		return checkInOutCar;
	}

	public void setCheckInOutCar(Set<CheckInOutCar> checkInOutCar)
	{
		this.checkInOutCar = checkInOutCar;
	}

	@Override
	public String toString()
	{
		return "Guard";
	}

	
}
