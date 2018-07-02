package com.apartment.management.service.interfaces.business;

import com.apartment.management.model.business.ResourceBilling;

public interface ResourceBillingService extends
		BillingDetailService<ResourceBilling>
{
	public void calcResourceBilling();
}
