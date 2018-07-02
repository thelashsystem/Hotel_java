package com.apartment.management.model.street;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "District")
public class District implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Short id;
	@Column(length = 50)
	private String name;
	@ManyToOne(cascade = CascadeType.ALL)
	private City city;

	// @OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
	// private Set<Ward> wards;
	// @OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
	// private Set<Address> addresses;

	public District()
	{
	}

	public Short getId()
	{
		return id;

	}

	public void setId(Short id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public City getCity()
	{
		return city;
	}

	public void setCity(City city)
	{
		this.city = city;
	}

}
