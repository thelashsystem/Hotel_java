package com.apartment.management.model.asset;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Equipment")
public class Equipment implements Serializable
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
	// @Column(columnDefinition="datetime")
	// private Date date;
	private boolean isUsed;
	private Integer quantity;
	@OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL)
	private List<ApartmentEquipment> rooms;
	@OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL)
	private Set<SupplierEquipment> supplierEquipment;
	private Integer status;
	@Transient
	private Map<Integer, String> statusReferences;

	public Equipment()
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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	// public Date getDate()
	// {
	// return date;
	// }
	//
	// public void setDate(Date date)
	// {
	// this.date = date;
	// }

	public boolean isUsed()
	{
		return isUsed;
	}

	public void setUsed(boolean isUsed)
	{
		this.isUsed = isUsed;
	}

	public Integer getQuantity()
	{
		return quantity;
	}

	public void setQuantity(Integer quantity)
	{
		this.quantity = quantity;
	}

	public List<ApartmentEquipment> getRooms()
	{
		return rooms;
	}

	public void setRooms(List<ApartmentEquipment> rooms)
	{
		this.rooms = rooms;
	}

	public Set<SupplierEquipment> getSupplierEquipment()
	{
		return supplierEquipment;
	}

	public void setSupplierEquipment(Set<SupplierEquipment> supplierEquipment)
	{
		this.supplierEquipment = supplierEquipment;
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
