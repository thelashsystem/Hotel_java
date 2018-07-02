package com.apartment.management.model.street;

import java.io.Serializable;

//@Entity
//@Table(name = "Ward")
public class Ward implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String wardName;
	// @ManyToOne(cascade = CascadeType.ALL)
	private District district;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
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

}
