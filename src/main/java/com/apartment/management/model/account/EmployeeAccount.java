package com.apartment.management.model.account;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.apartment.management.model.contract.AdvertisingContract;
import com.apartment.management.model.contract.CustomerContract;
import com.apartment.management.model.contract.EmployeeContract;
import com.apartment.management.model.contract.ServiceContract;
import com.apartment.management.model.contract.SupplyContract;
import com.apartment.management.model.news.Comment;
import com.apartment.management.model.news.News;
import com.apartment.management.model.person.Employee;

@Entity
@Table(name = "Employee_Account")
public class EmployeeAccount extends Account
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne(cascade = CascadeType.ALL)
	private Employee employee;
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Comment> comment;
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<SupplyContract> supplyContracts;
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<AdvertisingContract> advertisingContracts;
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<ServiceContract> serviceContracts;
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<CustomerContract> customerContracts;
	@OneToMany(mappedBy = "administratorAccount", cascade = CascadeType.ALL)
	private List<EmployeeContract> employeeContracts;
	@OneToMany(mappedBy = "employeeAccount")
	private List<News> news;

	public EmployeeAccount()
	{
	}

	public Employee getEmployee()
	{
		return employee;
	}

	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}

	public List<Comment> getComment()
	{
		return comment;
	}

	public void setComment(List<Comment> comment)
	{
		this.comment = comment;
	}

	public List<SupplyContract> getSupplyContracts()
	{
		return supplyContracts;
	}

	public void setSupplyContracts(List<SupplyContract> supplyContracts)
	{
		this.supplyContracts = supplyContracts;
	}

	public List<AdvertisingContract> getAdvertisingContracts()
	{
		return advertisingContracts;
	}

	public void setAdvertisingContracts(
			List<AdvertisingContract> advertisingContracts)
	{
		this.advertisingContracts = advertisingContracts;
	}

	public List<ServiceContract> getServiceContracts()
	{
		return serviceContracts;
	}

	public void setServiceContracts(List<ServiceContract> serviceContracts)
	{
		this.serviceContracts = serviceContracts;
	}

	public List<CustomerContract> getCustomerContracts()
	{
		return customerContracts;
	}

	public void setCustomerContracts(List<CustomerContract> customerContracts)
	{
		this.customerContracts = customerContracts;
	}

	public List<EmployeeContract> getEmployeeContracts()
	{
		return employeeContracts;
	}

	public void setEmployeeContracts(List<EmployeeContract> employeeContracts)
	{
		this.employeeContracts = employeeContracts;
	}

	public List<News> getNews()
	{
		return news;
	}

	public void setNews(List<News> news)
	{
		this.news = news;
	}

}
