package com.apartment.management.service.interfaces.contract;

import java.util.List;

import com.apartment.management.model.contract.CustomerContract;

public interface CustomerContractService extends
		ContractService<CustomerContract>
{
	public List<CustomerContract> getUnexpiredContract();
}
