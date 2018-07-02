package com.apartment.management.response.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.apartment.management.model.person.Customer;

public class CustomerDto implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String fullName;
	private String gender;
	private String phoneNumber;
	private String apartment;
	private String status;

	public CustomerDto()
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

	public String getFullName()
	{
		return fullName;
	}

	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public String getApartment()
	{
		return apartment;
	}

	public void setApartment(String apartment)
	{
		this.apartment = apartment;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public static CustomerDto map(Customer customer)
	{
		CustomerDto customerDto = new CustomerDto();
		customerDto.setId(customer.getId());
		customerDto.setFullName(customer.getProfile().getLastName() + " "
				+ customer.getProfile().getFirstName());
		customerDto.setGender(customer.getProfile().isGender() ? "Male"
				: "Female");
		customerDto.setPhoneNumber(customer.getProfile().getPhone());
		// customerDto.setApartmentName();

		return customerDto;
	}

	public static List<CustomerDto> map(List<Customer> listCustomer)
	{
		List<CustomerDto> listCustomerDto = new ArrayList<>();
		for ( Customer customer : listCustomer )
		{
			listCustomerDto.add(map(customer));
		}
		return listCustomerDto;
	}

}
