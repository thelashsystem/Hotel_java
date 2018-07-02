package com.apartment.management.response.dto;

import java.util.ArrayList;
import java.util.List;

import com.apartment.management.model.contract.AdvertisingContract;

public class AdvertisingContractDto extends ContractDto
{
	private String validityDate;

	public AdvertisingContractDto()
	{
	}

	public String getValidityDate()
	{
		return validityDate;
	}

	public void setValidityDate(String validityDate)
	{
		this.validityDate = validityDate;
	}

	public static AdvertisingContractDto map(AdvertisingContract contract)
	{
		AdvertisingContractDto contractDto = new AdvertisingContractDto();

		return contractDto;
	}

	public static List<AdvertisingContractDto> map(
			List<AdvertisingContract> listContract)
	{
		List<AdvertisingContractDto> listContractDto = new ArrayList<>();
		for ( AdvertisingContract contract : listContract )
		{
			listContractDto.add(map(contract));
		}
		return listContractDto;
	}
}
