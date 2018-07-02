package com.apartment.management.response.dto;

import java.util.ArrayList;
import java.util.List;

import com.apartment.management.model.contract.ServiceContract;

public class ServiceContractDto extends ContractDto
{
	public ServiceContractDto()
	{
	}

	public static ServiceContractDto map(ServiceContract contract)
	{
		ServiceContractDto contractDto = new ServiceContractDto();

		return contractDto;
	}

	public static List<ServiceContractDto> map(
			List<ServiceContract> listContract)
	{
		List<ServiceContractDto> listContractDto = new ArrayList<>();
		for ( ServiceContract contract : listContract )
		{
			listContractDto.add(map(contract));
		}
		return listContractDto;
	}
}
