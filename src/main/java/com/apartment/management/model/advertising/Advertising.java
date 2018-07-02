package com.apartment.management.model.advertising;

import java.io.Serializable;
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

import com.apartment.management.model.contract.AdvertisingContract;

@Entity
@Table(name = "Advertising")
public class Advertising implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(length = 100)
	private String name;
	@ManyToOne(cascade = CascadeType.ALL)
	private PositionAdvertising position;
	@ManyToOne(cascade = CascadeType.ALL)
	private AdvertisingContract contract;
	private Integer status;
	@Transient
	private Map<Integer, String> statusReferences;

	public Advertising()
	{
		statusReferences = new TreeMap<>();
		statusReferences.put(0, "Available");
		statusReferences.put(1, "Not Available");
		statusReferences.put(2, "Hidden");
		statusReferences.put(3, "Expired");
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

	public PositionAdvertising getPosition()
	{
		return position;
	}

	public void setPosition(PositionAdvertising position)
	{
		this.position = position;
	}

	public AdvertisingContract getContract()
	{
		return contract;
	}

	public void setContract(AdvertisingContract contract)
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
