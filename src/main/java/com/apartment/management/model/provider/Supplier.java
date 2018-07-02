package com.apartment.management.model.provider;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.apartment.management.model.contract.SupplyContract;

@Entity
@Table(name = "Supplier")
public class Supplier extends Provider
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
	private List<SupplyContract> contracts;

	public Supplier()
	{
	}

	public List<SupplyContract> getContracts()
	{
		return contracts;
	}

	public void setContracts(List<SupplyContract> contracts)
	{
		this.contracts = contracts;
	}

}
