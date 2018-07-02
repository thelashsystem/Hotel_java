package com.apartment.management.model.building;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
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

import com.apartment.management.model.business.ServicePrice;

@Entity
@Table(name = "Service")
public class Service implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Short id;
	private String name;
	private String hotLine;
	private boolean isHot;
	private boolean isNew;
	private String workingTime;
	private String shortDescription;
	@Column(columnDefinition = "text")
	private String description;
	@OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
	private List<ServicePrice> price;
	private Integer status;
	@Transient
	private Map<Integer, String> statusReferences;

	public Service()
	{
		statusReferences = new TreeMap<>();
		statusReferences.put(0, "Available");
		statusReferences.put(1, "Not Available");
		statusReferences.put(1, "Not Available");
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

	public String getHotLine()
	{
		return hotLine;
	}

	public void setHotLine(String hotLine)
	{
		this.hotLine = hotLine;
	}

	public boolean isHot()
	{
		return isHot;
	}

	public void setHot(boolean isHot)
	{
		this.isHot = isHot;
	}

	public boolean isNew()
	{
		return isNew;
	}

	public void setNew(boolean isNew)
	{
		this.isNew = isNew;
	}

	public List<ServicePrice> getPrice()
	{
		return price;
	}

	public void setPrice(List<ServicePrice> price)
	{
		this.price = price;
	}

	public String getStatus()
	{
		return statusReferences.get(status);
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public String getWorkingTime()
	{
		return workingTime;
	}

	public void setWorkingTime(String workingTime)
	{
		this.workingTime = workingTime;
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

}
