package com.apartment.management.model.business;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CancelService")
public class CancelService
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(columnDefinition = "datetime")
	private Timestamp date;
	@ManyToOne(cascade = CascadeType.ALL)
	private RegisterService registerService;

	public CancelService()
	{
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Timestamp getDate()
	{
		return date;
	}

	public void setDate(Timestamp date)
	{
		this.date = date;
	}

	public RegisterService getRegisterService()
	{
		return registerService;
	}

	public void setRegisterService(RegisterService registerService)
	{
		this.registerService = registerService;
	}

}
