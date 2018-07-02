package com.apartment.management.model.business;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ServiceBilling")
public class ServiceBilling extends BillingDetail
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne(cascade = CascadeType.ALL)
	private ServicePrice servicePrice;

	public ServiceBilling()
	{
	}

	public ServicePrice getServicePrice()
	{
		return servicePrice;
	}

	public void setServicePrice(ServicePrice servicePrice)
	{
		this.servicePrice = servicePrice;
	}

}
