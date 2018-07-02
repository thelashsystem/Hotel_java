package com.apartment.management.model.status;

import java.io.Serializable;

//@Entity
//@Table(name = "Status")
public class Status implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String description;

	public Status()
	{
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

}
