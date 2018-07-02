package com.apartment.management.model.asset;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.apartment.management.model.building.Apartment;
import com.apartment.management.model.person.Employee;

@Entity
@Table(name = "Apartment_Equipment")
public class ApartmentEquipment implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(columnDefinition = "datetime")
	private Timestamp usedDate;
	@Column(columnDefinition = "datetime")
	private Timestamp lastUsedDate;
	private Integer quantity;
	@ManyToOne(cascade = CascadeType.ALL)
	private Employee employee;
	@ManyToOne(cascade = CascadeType.ALL)
	private Apartment apartment;
	@ManyToOne(cascade = CascadeType.ALL)
	private Equipment equipment;
	private boolean isUsed;
	private Integer status;
	private boolean isHidden;
	@Transient
	private Map<Integer, String> statusReferences;

	public ApartmentEquipment()
	{
		statusReferences = new TreeMap<>();
		statusReferences.put(0, "Available");
		statusReferences.put(1, "Not Available");
		statusReferences.put(2, "Hidden");
		statusReferences.put(3, "Using");
		statusReferences.put(4, "Out of order");
		statusReferences.put(5, "Lost");
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Timestamp getUsedDate()
	{
		return usedDate;
	}

	public void setUsedDate(Timestamp usedDate)
	{
		this.usedDate = usedDate;
	}

	public Timestamp getLastUsedDate()
	{
		return lastUsedDate;
	}

	public void setLastUsedDate(Timestamp lastUsedDate)
	{
		this.lastUsedDate = lastUsedDate;
	}

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

	public Employee getEmployee()
	{
		return employee;
	}

	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}

	public Apartment getApartment()
	{
		return apartment;
	}

	public void setApartment(Apartment apartment)
	{
		this.apartment = apartment;
	}

	public Equipment getEquipment()
	{
		return equipment;
	}

	public void setEquipment(Equipment equipment)
	{
		this.equipment = equipment;
	}

	public String getStatus()
	{
		return statusReferences.get(status);
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public boolean isHidden()
	{
		return isHidden;
	}

	public void setHidden(boolean isHidden)
	{
		this.isHidden = isHidden;
	}

}
