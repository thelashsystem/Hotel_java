package com.apartment.management.model.building;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.web.multipart.MultipartFile;

import com.apartment.management.model.image.ImageBuilding;
import com.apartment.management.model.parkingLot.ParkingLot;
import com.apartment.management.model.person.Assignment;
import com.apartment.management.model.street.Address;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Building")
public class Building implements Serializable
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
	@Embedded
	private Address address;
	@Column(length = 30)
	private String phone;
	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "building", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ImageBuilding> images;
	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "building", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Floor> floors;
	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "building", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Assignment> assignment;
	@OneToMany(mappedBy = "building", cascade = CascadeType.ALL)
	private List<ParkingLot> parkingLot;
	private Short buildingSize;
	private boolean hasCarGarage;
	private boolean hasBasement;
	private Short yearBuild;
	@Transient
	private List<MultipartFile> files;
	private Integer status;
	@Transient
	private Map<Integer, String> statusReferences;
	private String officalEmail;

	public Building()
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

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	@JsonIgnore
	public List<ImageBuilding> getImages()
	{
		return images;
	}

	public void setImages(List<ImageBuilding> images)
	{
		this.images = images;
	}

	@JsonIgnore
	public List<Floor> getFloors()
	{
		return floors;
	}

	public void setFloors(List<Floor> floors)
	{
		this.floors = floors;
	}

	@JsonIgnore
	public List<Assignment> getAssignment()
	{
		return assignment;
	}

	public void setAssignment(List<Assignment> assignment)
	{
		this.assignment = assignment;
	}

	@JsonIgnore
	public List<ParkingLot> getParkingLot()
	{
		return parkingLot;
	}

	public void setParkingLot(List<ParkingLot> parkingLot)
	{
		this.parkingLot = parkingLot;
	}

	@JsonIgnore
	public String getStatus()
	{
		return statusReferences.get(status);
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public Short getBuildingSize()
	{
		return buildingSize;
	}

	public void setBuildingSize(Short buildingSize)
	{
		this.buildingSize = buildingSize;
	}

	public boolean isHasCarGarage()
	{
		return hasCarGarage;
	}

	public void setHasCarGarage(boolean hasCarGarage)
	{
		this.hasCarGarage = hasCarGarage;
	}

	public boolean isHasBasement()
	{
		return hasBasement;
	}

	public void setHasBasement(boolean hasBasement)
	{
		this.hasBasement = hasBasement;
	}

	public Short getYearBuild()
	{
		return yearBuild;
	}

	public void setYearBuild(Short yearBuild)
	{
		this.yearBuild = yearBuild;
	}

	@JsonIgnore
	public List<MultipartFile> getFiles()
	{
		return files;
	}

	public void setFiles(List<MultipartFile> files)
	{
		this.files = files;
	}

	public String getOfficalEmail()
	{
		return officalEmail;
	}

	public void setOfficalEmail(String officalEmail)
	{
		this.officalEmail = officalEmail;
	}

}
