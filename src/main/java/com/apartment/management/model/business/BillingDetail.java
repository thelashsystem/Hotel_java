package com.apartment.management.model.business;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BillingDetail implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Double subPrice;
	@ManyToOne(cascade = CascadeType.ALL)
	private Billing billing;

	public BillingDetail()
	{
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Double getSubPrice()
	{
		return subPrice;
	}

	public void setSubPrice(Double subPrice)
	{
		this.subPrice = subPrice;
	}

	public Billing getBilling()
	{
		return billing;
	}

	public void setBilling(Billing billing)
	{
		this.billing = billing;
	}

}
