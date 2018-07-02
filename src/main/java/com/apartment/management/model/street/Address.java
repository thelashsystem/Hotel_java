package com.apartment.management.model.street;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class Address implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String addressName;
	@Column(length = 50)
	private String wardName;
	@ManyToOne(cascade = CascadeType.ALL)
	private District district;

	public Address()
	{
	}

	public String getAddressName()
	{
		return addressName;
	}

	public void setAddressName(String addressName)
	{
		this.addressName = addressName;
	}

	public String getWardName()
	{
		return wardName;
	}

	public void setWardName(String wardName)
	{
		this.wardName = wardName;
	}

	public District getDistrict()
	{
		return district;
	}

	public void setDistrict(District district)
	{
		this.district = district;
	}

	@Override
	public String toString()
	{
		return addressName + " " + wardName + " " + district.getName();
	}

}
