package com.apartment.management.model.contract;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.apartment.management.model.account.EmployeeAccount;
import com.apartment.management.model.building.Service;
import com.apartment.management.model.provider.ServiceProvider;

@Entity
@Table(name = "Service_Contract")
public class ServiceContract extends Contract
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne(cascade = CascadeType.ALL)
	private Service service;
	@ManyToOne(cascade = CascadeType.ALL)
	private ServiceProvider serviceProvider;
	@ManyToOne(cascade = CascadeType.ALL)
	private EmployeeAccount employee;

	public ServiceContract()
	{
	}

	public Service getService()
	{
		return service;
	}

	public void setService(Service service)
	{
		this.service = service;
	}

	public ServiceProvider getServiceProvider()
	{
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProvider serviceProvider)
	{
		this.serviceProvider = serviceProvider;
	}

	public EmployeeAccount getEmployee()
	{
		return employee;
	}

	public void setEmployee(EmployeeAccount employee)
	{
		this.employee = employee;
	}

}
