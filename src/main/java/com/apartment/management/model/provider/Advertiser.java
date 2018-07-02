package com.apartment.management.model.provider;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.apartment.management.model.contract.AdvertisingContract;

@Entity
@Table(name = "Advertiser")
public class Advertiser extends Provider
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "advertiser", cascade = CascadeType.ALL)
	private Set<AdvertisingContract> contracts;

	public Advertiser()
	{
	}

	public Set<AdvertisingContract> getContracts()
	{
		return contracts;
	}

	public void setContracts(Set<AdvertisingContract> contracts)
	{
		this.contracts = contracts;
	}

}
