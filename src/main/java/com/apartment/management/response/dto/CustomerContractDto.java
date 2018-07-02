package com.apartment.management.response.dto;

import java.util.ArrayList;
import java.util.List;

import com.apartment.management.model.contract.CustomerContract;
import com.apartment.management.model.person.Customer;
import com.apartment.management.model.person.Employee;

public class CustomerContractDto extends ContractDto
{
	private Employee employee;
	private Customer customer;

	public CustomerContractDto()
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

	public Customer getCustomer()
	{
		return customer;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	public static CustomerContractDto map(CustomerContract contract)
	{
		CustomerContractDto contractDto = new CustomerContractDto();
		contractDto.setId(contract.getId());
		contractDto.setSubject(contract.getSubject());
		contractDto.setSignedDate(contract.getSignedDate());
		contractDto.setExpiredDate(contract.getExpiredDate());
		contractDto.setStatus(contract.getStatus());
		contractDto.setCustomer(contract.getBookingApartment().getCustomer());
		contractDto.setEmployee(contract.getEmployee().getEmployee());
		return contractDto;
	}

	public static List<CustomerContractDto> map(
			List<CustomerContract> listContract)
	{
		List<CustomerContractDto> listContractDto = new ArrayList<>();
		for ( CustomerContract contract : listContract )
		{
			listContractDto.add(map(contract));
		}
		return listContractDto;
	}
}
