package com.apartment.management.service.interfaces.business;

import java.util.List;

import com.apartment.management.model.business.Billing;
import com.apartment.management.model.contract.CustomerContract;
import com.apartment.management.service.interfaces.GeneralService;

public interface BillingService extends GeneralService<Billing, Integer>
{
	public Billing createdBilling(CustomerContract customerContract);

	public List<Billing> createdBillings();
}
