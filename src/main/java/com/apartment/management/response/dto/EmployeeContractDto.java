package com.apartment.management.response.dto;

import java.util.ArrayList;
import java.util.List;

import com.apartment.management.model.contract.Contract;
import com.apartment.management.model.contract.CustomerContract;

public class EmployeeContractDto extends ContractDto
{
	private Integer id;
	private String signedDate;
	private String subject;
	private String employee;
	private String serviceProvider;
	private String supplier;
	private String advertisingProvider;
	private String service;
	private String expiredDate;
	private String validityDate;
	private String status;

	public EmployeeContractDto()
	{
	}

	public static EmployeeContractDto map(CustomerContract contract)
	{
		EmployeeContractDto contractDto = new EmployeeContractDto();

		return contractDto;
	}

	public static List<EmployeeContractDto> map(List<CustomerContract> listContract)
	{
		List<EmployeeContractDto> listContractDto = new ArrayList<>();
		for ( CustomerContract contract : listContract )
		{
			listContractDto.add(map(contract));
		}
		return listContractDto;
	}
}
