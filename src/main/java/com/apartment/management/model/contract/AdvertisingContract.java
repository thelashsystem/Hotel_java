package com.apartment.management.model.contract;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.apartment.management.model.account.EmployeeAccount;
import com.apartment.management.model.advertising.Advertising;
import com.apartment.management.model.provider.Advertiser;

@Entity
@Table(name = "AdvertisingContract")
public class AdvertisingContract extends Contract
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne(cascade = CascadeType.ALL)
	private Advertiser advertiser;
	@OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
	private Set<Advertising> advertising;
	@ManyToOne(cascade = CascadeType.ALL)
	private EmployeeAccount employee;

	public AdvertisingContract()
	{
	}

	public Advertiser getAdvertiser()
	{
		return advertiser;
	}

	public void setAdvertiser(Advertiser advertiser)
	{
		this.advertiser = advertiser;
	}

	public Set<Advertising> getAdvertising()
	{
		return advertising;
	}

	public void setAdvertising(Set<Advertising> advertising)
	{
		this.advertising = advertising;
	}

	public EmployeeAccount getEmployee()
	{
		return employee;
	}

	public void setEmployee(EmployeeAccount employee)
	{
		this.employee = employee;
	}

}
