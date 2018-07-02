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

@Entity
@Table(name = "ResourcePrice")
public class ResourcePrice implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Date updatedDate;
	private Double price;
	private String measure;
	@ManyToOne(cascade = CascadeType.ALL)
	private Resource resource;
	@OneToMany(mappedBy = "resourcePrice", cascade = CascadeType.ALL)
	private List<ResourceBilling> billing;
	private Integer status;
	@Transient
	private Map<Integer, String> statusReferences;

	public ResourcePrice()
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

	public Date getUpdatedDate()
	{
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate)
	{
		this.updatedDate = updatedDate;
	}

	public Double getPrice()
	{
		return price;
	}

	public void setPrice(Double price)
	{
		this.price = price;
	}

	public String getMeasure()
	{
		return measure;
	}

	public void setMeasure(String measure)
	{
		this.measure = measure;
	}

	public Resource getResource()
	{
		return resource;
	}

	public void setResource(Resource resource)
	{
		this.resource = resource;
	}

	public List<ResourceBilling> getBilling()
	{
		return billing;
	}

	public void setBilling(List<ResourceBilling> billing)
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
