package com.apartment.management.model.business;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ResourceBilling")
public class ResourceBilling extends BillingDetail
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer quantity;
	@ManyToOne(cascade = CascadeType.ALL)
	private ResourcePrice resourcePrice;

	public ResourceBilling()
	{
	}

	public Integer getQuantity()
	{
		return quantity;
	}

	public void setQuantity(Integer quantity)
	{
		this.quantity = quantity;
	}

	public ResourcePrice getResourcePrice()
	{
		return resourcePrice;
	}

	public void setResourcePrice(ResourcePrice resourcePrice)
	{
		this.resourcePrice = resourcePrice;
	}

}
