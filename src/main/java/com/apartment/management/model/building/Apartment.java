package com.apartment.management.model.building;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.apartment.management.model.asset.ApartmentEquipment;
import com.apartment.management.model.business.BookingApartment;
import com.apartment.management.model.image.ImageApartment;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Apartment")
public class Apartment implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(length = 50)
	private String name;
	@Column(length = 75)
	private String shortDescription;
	@Column(columnDefinition = "text")
	private String description;
	@ManyToOne(cascade = CascadeType.ALL)
	private ApartmentType apartmentType;
	@ManyToOne(cascade = CascadeType.ALL)
	private Floor floor;
	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "apartment", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ImageApartment> image;
	@OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL)
	private List<ApartmentEquipment> equipment;
	@OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL)
	private Set<BookingApartment> bookingApartment;
	private String floorPlanImage;
	private Short apartmentSize;
	private Byte numberBedroom;
	private Byte numberBathroom;
	private Byte numberRoom;
	private Integer status;
	@Transient
	private Map<Integer, String> statusReferences;

	public Apartment()
	{
		statusReferences = new TreeMap<>();
		statusReferences.put(0, "Available");
		statusReferences.put(1, "Not Available");
		statusReferences.put(2, "Hidden");
		statusReferences.put(3, "Repairing");
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
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

	public Floor getFloor()
	{
		return floor;
	}

	public void setFloor(Floor floor)
	{
		this.floor = floor;
	}

	@JsonIgnore
	public List<ImageApartment> getImage()
	{
		return image;
	}

	public void setImage(List<ImageApartment> image)
	{
		this.image = image;
	}

	@JsonIgnore
	public List<ApartmentEquipment> getEquipment()
	{
		return equipment;
	}

	public void setEquipment(List<ApartmentEquipment> equipment)
	{
		this.equipment = equipment;
	}

	public ApartmentType getApartmentType()
	{
		return apartmentType;
	}

	public void setApartmentType(ApartmentType apartmentType)
	{
		this.apartmentType = apartmentType;
	}

	@JsonIgnore
	public Set<BookingApartment> getBookingApartment()
	{
		return bookingApartment;
	}

	public void setBookingApartment(Set<BookingApartment> bookingApartment)
	{
		this.bookingApartment = bookingApartment;
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

	public Short getApartmentSize()
	{
		return apartmentSize;
	}

	public void setApartmentSize(Short apartmentSize)
	{
		this.apartmentSize = apartmentSize;
	}

	public Byte getNumberBedroom()
	{
		return numberBedroom;
	}

	public void setNumberBedroom(Byte numberBedroom)
	{
		this.numberBedroom = numberBedroom;
	}

	public Byte getNumberBathroom()
	{
		return numberBathroom;
	}

	public void setNumberBathroom(Byte numberBathroom)
	{
		this.numberBathroom = numberBathroom;
	}

	public Byte getNumberRoom()
	{
		return numberRoom;
	}

	public void setNumberRoom(Byte numberRoom)
	{
		this.numberRoom = numberRoom;
	}

	public String getShortDescription()
	{
		return shortDescription;
	}

	public void setShortDescription(String shortDescription)
	{
		this.shortDescription = shortDescription;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getFloorPlanImage()
	{
		return floorPlanImage;
	}

	public void setFloorPlanImage(String floorPlanImage)
	{
		this.floorPlanImage = floorPlanImage;
	}

}
