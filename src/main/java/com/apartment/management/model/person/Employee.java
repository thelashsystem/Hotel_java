package com.apartment.management.model.person;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.apartment.management.model.account.EmployeeAccount;
import com.apartment.management.model.asset.ApartmentEquipment;
import com.apartment.management.model.parkingLot.Owner;

@Entity
@Table(name = "Employee")
public class Employee extends Person
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "EmployeeCode", unique = true, nullable = false)
	private String employeeCode;
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Assignment> assignment;
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Owner> transport;
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<EmployeeAccount> account;
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<ApartmentEquipment> roomEquipment;
	private Date hiredDate;

	public Employee()
	{
	}

	public String getEmployeeCode()
	{
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode)
	{
		this.employeeCode = employeeCode;
	}

	public List<Assignment> getAssignment()
	{
		return assignment;
	}

	public void setAssignment(List<Assignment> assignment)
	{
		this.assignment = assignment;
	}

	public List<Owner> getTransport()
	{
		return transport;
	}

	public void setTransport(List<Owner> transport)
	{
		this.transport = transport;
	}

	public List<EmployeeAccount> getAccount()
	{
		return account;
	}

	public void setAccount(List<EmployeeAccount> account)
	{
		this.account = account;
	}

	public List<ApartmentEquipment> getRoomEquipment()
	{
		return roomEquipment;
	}

	public void setRoomEquipment(List<ApartmentEquipment> roomEquipment)
	{
		this.roomEquipment = roomEquipment;
	}

	public Date getHiredDate()
	{
		return hiredDate;
	}

	public void setHiredDate(Date hiredDate)
	{
		this.hiredDate = hiredDate;
	}

}
