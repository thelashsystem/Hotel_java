package com.apartment.management.model.business;

import java.io.Serializable;
import java.sql.Date;
import java.util.Map;
import java.util.Set;
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

import com.apartment.management.model.building.Service;

@Entity
@Table(name = "ServicePrice")
public class ServicePrice implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Date updateDate;
	private Double price;
	private String measure;
	@OneToMany(mappedBy = "servicePrice", cascade = CascadeType.ALL)
	private Set<ServiceBilling> billing;
	@ManyToOne(cascade = CascadeType.ALL)
	private Service service;
	private Integer status;
	@Transient
	private Map<Integer, String> statusReferences;

	public ServicePrice()
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

	public Date getUpdateDate()
	{
		return updateDate;
	}

	public void setUpdateDate(Date updateDate)
	{
		this.updateDate = updateDate;
	}

	public String getMeasure()
	{
		return measure;
	}

	public void setMeasure(String measure)
	{
		this.measure = measure;
	}

	public Double getPrice()
	{
		return price;
	}

	public void setPrice(Double price)
	{
		this.price = price;
	}

	public Set<ServiceBilling> getBilling()
	{
		return billing;
	}

	public void setBilling(Set<ServiceBilling> billing)
	{
		this.billing = billing;
	}

	public Service getService()
	{
		return service;
	}

	public void setService(Service service)
	{
		this.service = service;
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
