package com.apartment.management.model.business;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.apartment.management.model.contract.CustomerContract;

@Entity
@Table(name = "Billing")
public class Billing implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne(cascade = CascadeType.ALL)
	private CustomerContract customerContract;
	@OneToMany(mappedBy = "billing", cascade = CascadeType.ALL)
	private List<Invoice> invoices;
	@OneToMany(mappedBy = "billing", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ApartmentBilling> apartmentBilling;
	@OneToMany(mappedBy = "billing", cascade = CascadeType.ALL)
	private List<ResourceBilling> resourceBilling;
	@OneToMany(mappedBy = "billing", cascade = CascadeType.ALL)
	private List<ServiceBilling> serviceBilling;
	private Integer status;
	@Transient
	private Map<Integer, String> statusReferences;
	private Date createdDate;

	private Double totalPrice;

	public Billing()
	{
		statusReferences = new TreeMap<>();
		statusReferences.put(0, "Available");
		statusReferences.put(1, "Not Available");
		statusReferences.put(2, "Hidden");
		statusReferences.put(3, "Pending");
		statusReferences.put(4, "Owed");
		statusReferences.put(5, "Paid");
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Date getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}

	public Double getTotalPrice()
	{
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	public CustomerContract getCustomerContract()
	{
		return customerContract;
	}

	public void setCustomerContract(CustomerContract customerContract)
	{
		this.customerContract = customerContract;
	}

	public List<Invoice> getInvoices()
	{
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices)
	{
		this.invoices = invoices;
	}

	public List<ApartmentBilling> getApartmentBilling()
	{
		return apartmentBilling;
	}

	public void setApartmentBilling(List<ApartmentBilling> apartmentBilling)
	{
		this.apartmentBilling = apartmentBilling;
	}

	public List<ResourceBilling> getResourceBilling()
	{
		return resourceBilling;
	}

	public void setResourceBilling(List<ResourceBilling> resourceBilling)
	{
		this.resourceBilling = resourceBilling;
	}

	public List<ServiceBilling> getServiceBilling()
	{
		return serviceBilling;
	}

	public void setServiceBilling(List<ServiceBilling> serviceBilling)
	{
		this.serviceBilling = serviceBilling;
	}

	public String getStatus()
	{
		return statusReferences.get(status);
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

}
