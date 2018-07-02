package com.apartment.management.dao.interfaces.business;

import com.apartment.management.dao.interfaces.GeneralDao;
import com.apartment.management.model.business.Billing;
import com.apartment.management.model.contract.CustomerContract;

public interface BillingDaoInf extends GeneralDao<Billing, Integer>
{
	public Integer createBilling(CustomerContract customerContract);
}
