package com.apartment.management.dao.interfaces.contract;

import java.util.Date;
import java.util.List;

import com.apartment.management.model.contract.CustomerContract;

public interface CustomerContractDaoInf extends
		ContractDaoInf<CustomerContract>
{
	public List<CustomerContract> getUnexpiredContract();

	public List<CustomerContract> getUnexpiredContract(Date currentDate);
}
