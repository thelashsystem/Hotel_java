package com.apartment.management.model.parkingLot;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.apartment.management.model.building.Building;

@Entity
@Table(name = "ParkingLot")
public class ParkingLot implements Serializable
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
	@Column(columnDefinition = "datetime")
	private Timestamp createdDate;
	@OneToMany(mappedBy = "parkingLot", cascade = CascadeType.ALL)
	private List<CheckInOutCar> checkIn;
	@ManyToOne(cascade = CascadeType.ALL)
	private Building building;
	private Integer capacity;
	private Integer status;
	@Transient
	private Map<Integer, String> statusReferences;

	public ParkingLot()
	{
		statusReferences = new TreeMap<>();
		statusReferences.put(0, "Available");
		statusReferences.put(1, "Not Available");
		statusReferences.put(2, "Hidden");
		statusReferences.put(3, "Repairing");
		statusReferences.put(4, "Closed");
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

	public List<CheckInOutCar> getCheckIn()
	{
		return checkIn;
	}

	public void setCheckIn(List<CheckInOutCar> checkIn)
	{
		this.checkIn = checkIn;
	}

	public Building getBuilding()
	{
		return building;
	}

	public void setBuilding(Building building)
	{
		this.building = building;
	}

	public String getStatus()
	{
		return statusReferences.get(status);
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public Integer getCapacity()
	{
		return capacity;
	}

	public void setCapacity(Integer capacity)
	{
		this.capacity = capacity;
	}

	public Timestamp getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate)
	{
		this.createdDate = createdDate;
	}

}
