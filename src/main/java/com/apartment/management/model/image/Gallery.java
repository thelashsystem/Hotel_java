package com.apartment.management.model.image;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Gallery implements Serializable
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
	@Column(length = 50)
	private String name;
	private String imagePath;
	@Column(columnDefinition = "text")
	private String description;
	private Integer status;
	private Short orderNum;
	@Transient
	private Map<Integer, String> statusReferences;
	private boolean isHot;
	private boolean isNew;

	public Gallery()
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

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
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

	public String getImagePath()
	{
		return imagePath;
	}

	public void setImagePath(String imagePath)
	{
		this.imagePath = imagePath;
	}

	public String getStatus()
	{
		return statusReferences.get(status);
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public Timestamp getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate)
	{
		this.createdDate = createdDate;
	}

	public Short getOrderNum()
	{
		return orderNum;
	}

	public void setOrderNum(Short orderNum)
	{
		this.orderNum = orderNum;
	}

}
