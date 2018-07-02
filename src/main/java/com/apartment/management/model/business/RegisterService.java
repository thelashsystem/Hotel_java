package com.apartment.management.model.business;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.apartment.management.model.building.Service;
import com.apartment.management.model.person.Customer;

@Entity
@Table(name = "RegisterService")
public class RegisterService
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(columnDefinition = "datetime")
	private Timestamp regDate;
	@ManyToOne(cascade = CascadeType.ALL)
	private Service service;
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;
	@OneToMany(mappedBy = "registerService", cascade = CascadeType.ALL)
	private Set<CancelService> cancelService;

	public RegisterService()
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

	public Timestamp getRegDate()
	{
		return regDate;
	}

	public void setRegDate(Timestamp regDate)
	{
		this.regDate = regDate;
	}

	public Service getService()
	{
		return service;
	}

	public void setService(Service service)
	{
		this.service = service;
	}

	public Customer getCustomer()
	{
		return customer;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	public Set<CancelService> getCancelService()
	{
		return cancelService;
	}

	public void setCancelService(Set<CancelService> cancelService)
	{
		this.cancelService = cancelService;
	}

}
