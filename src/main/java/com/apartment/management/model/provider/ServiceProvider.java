package com.apartment.management.model.provider;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.apartment.management.model.contract.ServiceContract;

@Entity
@Table(name = "ServiceProvider")
public class ServiceProvider extends Provider
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "serviceProvider", cascade = CascadeType.ALL)
	private Set<ServiceContract> contract;

	public ServiceProvider()
	{
	}

	public Set<ServiceContract> getContract()
	{
		return contract;
	}

	public void setContract(Set<ServiceContract> contract)
	{
		this.contract = contract;
	}

}
