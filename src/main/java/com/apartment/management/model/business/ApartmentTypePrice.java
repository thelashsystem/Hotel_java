package com.apartment.management.model.business;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.apartment.management.model.building.ApartmentType;

@Entity
@Table(name = "ApartmentTypePrice")
public class ApartmentTypePrice implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Double price;
	private Date updatedDate;
	@ManyToOne(cascade = CascadeType.ALL)
	private ApartmentType apartmentType;
	@OneToMany(mappedBy = "apartmentTypePrice", cascade = CascadeType.ALL)
	private List<ApartmentBilling> billing;
	@Transient
	private Map<Integer, String> statusReferences;
	private Integer status;

	public ApartmentTypePrice()
	{
		statusReferences = new TreeMap<>();
		statusReferences.put(0, "Available");
		statusReferences.put(1, "Not Available");
		statusReferences.put(2, "Hidden");
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Double getPrice()
	{
		return price;
	}

	public void setPrice(Double price)
	{
		this.price = price;
	}

	public Date getUpdatedDate()
	{
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate)
	{
		this.updatedDate = updatedDate;
	}

	public ApartmentType getApartmentType()
	{
		return apartmentType;
	}

	public void setApartmentType(ApartmentType apartmentType)
	{
		this.apartmentType = apartmentType;
	}

	public List<ApartmentBilling> getBilling()
	{
		return billing;
	}

	public void setBilling(List<ApartmentBilling> billing)
	{
		this.billing = billing;
	}

	public String getStatus()
	{
		return statusReferences.get(status);
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}
	
	

}
