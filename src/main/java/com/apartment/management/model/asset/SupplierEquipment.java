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

import com.apartment.management.model.contract.SupplyContract;

@Entity
@Table(name = "Supplier_Equipment")
public class SupplierEquipment implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(columnDefinition = "datetime")
	private Timestamp createdDate;
	private Integer quantity;
	@ManyToOne(cascade = CascadeType.ALL)
	private Equipment equipment;
	@ManyToOne(cascade = CascadeType.ALL)
	private SupplyContract contract;
	private Integer status;
	@Transient
	private Map<Integer, String> statusReferences;

	public SupplierEquipment()
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

	public Timestamp getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate)
	{
		this.createdDate = createdDate;
	}

	public Integer getQuantity()
	{
		return quantity;
	}

	public void setQuantity(Integer quantity)
	{
		this.quantity = quantity;
	}

	public Equipment getEquipment()
	{
		return equipment;
	}

	public void setEquipment(Equipment equipment)
	{
		this.equipment = equipment;
	}

	public SupplyContract getContract()
	{
		return contract;
	}

	public void setContract(SupplyContract contract)
	{
		this.contract = contract;
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
