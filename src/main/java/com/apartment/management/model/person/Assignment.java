package com.apartment.management.model.person;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.apartment.management.model.building.Building;

@Entity
@Table(name = "Assignment")
public class Assignment implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne(cascade = CascadeType.ALL)
	private Building building;
	@ManyToOne(cascade = CascadeType.ALL)
	private Employee employee;
	private boolean isManager;
	@Column(columnDefinition = "datetime")
	private Timestamp assignDate;

	public Assignment()
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

	public Building getBuilding()
	{
		return building;
	}

	public void setBuilding(Building building)
	{
		this.building = building;
	}

	public Employee getEmployee()
	{
		return employee;
	}

	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}

	public boolean isManager()
	{
		return isManager;
	}

	public void setManager(boolean isManager)
	{
		this.isManager = isManager;
	}

	public Timestamp getAssignDate()
	{
		return assignDate;
	}

	public void setAssignDate(Timestamp assignDate)
	{
		this.assignDate = assignDate;
	}

}
