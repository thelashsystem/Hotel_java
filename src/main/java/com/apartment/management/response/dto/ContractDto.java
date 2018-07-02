package com.apartment.management.response.dto;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.apartment.management.model.contract.Contract;
import com.apartment.management.model.person.Customer;

public class ContractDto
{
	private Integer id;
	private String signedDate;
	private String subject;
	private String expiredDate;
	private String status;
	@Autowired
	@Qualifier("dateFormat_MMddyyyy")
	private SimpleDateFormat dateFormat;


	public ContractDto()
	{
		dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getSignedDate()
	{
		return signedDate;
	}

	public void setSignedDate(Date signedDate)
	{
		this.signedDate = dateFormat.format(signedDate);
	}

	public void setSignedDate(String signedDate)
	{
		this.signedDate = signedDate;
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	public String getExpiredDate()
	{
		return expiredDate;
	}

	public void setExpiredDate(String expiredDate)
	{
		this.expiredDate = expiredDate;
	}

	public void setExpiredDate(Date expiredDate)
	{
		this.expiredDate = dateFormat.format(expiredDate);
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

}
