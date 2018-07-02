package com.apartment.management.model.building;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Floor")
public class Floor implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne(cascade = CascadeType.ALL)
	private Building building;
	@ManyToOne(cascade = CascadeType.ALL)
	private FloorGroup floorGroup;
	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "floor", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Apartment> apartment;

	public Floor()
	{
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Building getBuilding()
	{
		return building;
	}

	public void setBuilding(Building building)
	{
		this.building = building;
	}

	@JsonIgnore
	public List<Apartment> getApartment()
	{
		return apartment;
	}

	public void setApartment(List<Apartment> apartment)
	{
		this.apartment = apartment;
	}

	public FloorGroup getFloorGroup()
	{
		return floorGroup;
	}

	public void setFloorGroup(FloorGroup floorGroup)
	{
		this.floorGroup = floorGroup;
	}

}
