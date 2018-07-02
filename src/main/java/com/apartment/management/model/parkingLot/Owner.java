package com.apartment.management.model.parkingLot;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.apartment.management.model.person.Customer;
import com.apartment.management.model.person.Employee;

@Entity
@Table(name = "Owner")
public class Owner implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne(cascade = CascadeType.ALL)
	private Employee employee;
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;
	@ManyToOne(cascade = CascadeType.ALL)
	private Transport transport;
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private List<CheckInOutCar> checkInOut;

	public Owner()
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

	public Employee getEmployee()
	{
		return employee;
	}

	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}

	public Customer getCustomer()
	{
		return customer;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	public Transport getTransport()
	{
		return transport;
	}

	public void setTransport(Transport transport)
	{
		this.transport = transport;
	}

	public List<CheckInOutCar> getCheckInOut()
	{
		return checkInOut;
	}

	public void setCheckInOut(List<CheckInOutCar> checkInOut)
	{
		this.checkInOut = checkInOut;
	}

}
