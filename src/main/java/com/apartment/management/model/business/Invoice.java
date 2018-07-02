package com.apartment.management.model.business;

import java.io.Serializable;
import java.sql.Date;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Invoice")
public class Invoice implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date date;
	@ManyToOne(cascade = CascadeType.ALL)
	private Billing billing;
	private Integer status;
	@Transient
	private Map<Integer, String> statusReferences;

	public Invoice()
	{
		statusReferences = new TreeMap<>();
		statusReferences.put(0, "Available");
		statusReferences.put(1, "Not Available");
		statusReferences.put(2, "Hidden");
		statusReferences.put(3, "Pending");
		statusReferences.put(4, "Owed");
		statusReferences.put(5, "Paid");
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public Billing getBilling()
	{
		return billing;
	}

	public void setBilling(Billing billing)
	{
		this.billing = billing;
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
