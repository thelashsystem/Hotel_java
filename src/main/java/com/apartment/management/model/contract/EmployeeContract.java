package com.apartment.management.model.contract;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.apartment.management.model.account.EmployeeAccount;
import com.apartment.management.model.person.Employee;

@Entity
@Table(name = "Employee_Contract")
public class EmployeeContract extends Contract
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne(cascade = CascadeType.ALL)
	private Employee employee;
	@ManyToOne(cascade = CascadeType.ALL)
	private EmployeeAccount administratorAccount;

	public EmployeeContract()
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

	public EmployeeAccount getAdministratorAccount()
	{
		return administratorAccount;
	}

	public void setAdministratorAccount(EmployeeAccount administratorAccount)
	{
		this.administratorAccount = administratorAccount;
	}

}
