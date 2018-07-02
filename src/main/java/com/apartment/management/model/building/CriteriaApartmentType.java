package com.apartment.management.model.building;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CriteriaApartmentType")
public class CriteriaApartmentType implements Serializable
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
	@Column(columnDefinition = "text")
	private String description;

	private Byte orderNum;

	private boolean isActive;

	@ManyToOne(cascade = CascadeType.ALL)
	private Icon icon;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Criteria_ApartmentType")
	private Set<ApartmentType> apartmentType;
	private Integer status;
	@Transient
	private Map<Integer, String> statusReferences;

	public CriteriaApartmentType()
	{
		statusReferences = new TreeMap<>();
		statusReferences.put(0, "Available");
		statusReferences.put(1, "Hidden");
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

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public boolean isActive()
	{
		return isActive;
	}

	public void setActive(boolean isActive)
	{
		this.isActive = isActive;
	}

	public Set<ApartmentType> getApartmentType()
	{
		return apartmentType;
	}

	public void setApartmentType(Set<ApartmentType> apartmentType)
	{
		this.apartmentType = apartmentType;
	}

	public Icon getIcon()
	{
		return icon;
	}

	public void setIcon(Icon icon)
	{
		this.icon = icon;
	}

	public Byte getOrderNum()
	{
		return orderNum;
	}

	public void setOrderNum(Byte orderNum)
	{
		this.orderNum = orderNum;
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
