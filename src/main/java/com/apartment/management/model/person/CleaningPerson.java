package com.apartment.management.model.person;

import javax.persistence.Entity;

@Entity
public class CleaningPerson extends Employee
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CleaningPerson()
	{
	}

	@Override
	public String toString()
	{
		return "CleaningPerson";
	}
	
	
}
