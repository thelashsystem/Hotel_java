package com.apartment.management.model.contract;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.apartment.management.model.account.EmployeeAccount;
import com.apartment.management.model.business.Billing;
import com.apartment.management.model.business.BookingApartment;

@Entity
@Table(name = "Customer_Contract")
public class CustomerContract extends Contract
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne(cascade = CascadeType.ALL)
	private BookingApartment bookingApartment;
	@ManyToOne(cascade = CascadeType.ALL)
	private EmployeeAccount employee;
	@OneToMany(mappedBy = "customerContract", cascade = CascadeType.ALL)
	private List<Billing> billing;

	public CustomerContract()
	{
	}

	public BookingApartment getBookingApartment()
	{
		return bookingApartment;
	}

	public void setBookingApartment(BookingApartment bookingApartment)
	{
		this.bookingApartment = bookingApartment;
	}

	public EmployeeAccount getEmployee()
	{
		return employee;
	}

	public void setEmployee(EmployeeAccount employee)
	{
		this.employee = employee;
	}

	public List<Billing> getBilling()
	{
		return billing;
	}

	public void setBilling(List<Billing> billing)
	{
		this.billing = billing;
	}

}
