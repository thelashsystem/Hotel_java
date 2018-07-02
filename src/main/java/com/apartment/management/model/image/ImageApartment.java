package com.apartment.management.model.image;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.apartment.management.model.building.Apartment;

@Entity
@Table(name = "Image_Apartment")
public class ImageApartment extends Gallery
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne(cascade = CascadeType.ALL)
	private Apartment apartment;

	public ImageApartment()
	{
	}

	public Apartment getApartment()
	{
		return apartment;
	}

	public void setApartment(Apartment apartment)
	{
		this.apartment = apartment;
	}

}
