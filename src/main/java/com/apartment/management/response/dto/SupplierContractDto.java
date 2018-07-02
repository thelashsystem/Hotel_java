package com.apartment.management.response.dto;

import java.util.ArrayList;
import java.util.List;

import com.apartment.management.model.contract.SupplyContract;

public class SupplierContractDto extends ContractDto
{
	public SupplierContractDto()
	{
	}
	
	public static SupplierContractDto map(SupplyContract contract)
	{
		SupplierContractDto contractDto = new SupplierContractDto();
		
		return contractDto;
	}

	public static List<SupplierContractDto> map(
			List<SupplyContract> listContract)
	{
		List<SupplierContractDto> listContractDto = new ArrayList<>();
		for ( SupplyContract contract : listContract )
		{
			listContractDto.add(map(contract));
		}
		return listContractDto;
	}
}
