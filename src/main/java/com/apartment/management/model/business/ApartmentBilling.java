package com.apartment.management.model.business;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ApartmentBilling")
public class ApartmentBilling extends BillingDetail
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne(cascade = CascadeType.ALL)
	private ApartmentTypePrice apartmentTypePrice;

	public ApartmentBilling()
	{
	}

	public ApartmentTypePrice getApartmentTypePrice()
	{
		return apartmentTypePrice;
	}

	public void setApartmentTypePrice(ApartmentTypePrice apartmentTypePrice)
	{
		this.apartmentTypePrice = apartmentTypePrice;
	}

}
