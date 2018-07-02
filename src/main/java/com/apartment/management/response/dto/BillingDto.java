package com.apartment.management.response.dto;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.apartment.management.model.business.Billing;

public class BillingDto
{
	private Integer id;
	private String createdDate;
	private String customer;
	private String apartment;
	private Double totalPrice;
	private String checker;
	private String status;
	@Autowired
	@Qualifier("dateFormat_MMddyyyy")
	private SimpleDateFormat dateFormat;

	public BillingDto()
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

	public String getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = dateFormat.format(createdDate);
	}

	public String getCustomer()
	{
		return customer;
	}

	public void setCustomer(String customer)
	{
		this.customer = customer;
	}

	public String getApartment()
	{
		return apartment;
	}

	public void setApartment(String apartment)
	{
		this.apartment = apartment;
	}

	public Double getTotalPrice()
	{
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getChecker()
	{
		return checker;
	}

	public void setChecker(String checker)
	{
		this.checker = checker;
	}

	public static BillingDto map(Billing billing)
	{
		BillingDto billingDto = new BillingDto();
		billingDto.setId(billing.getId());
		billingDto.setTotalPrice(billing.getTotalPrice());
		billingDto.setCreatedDate(billing.getCreatedDate());
		billingDto.setCustomer(billing.getCustomerContract()
				.getBookingApartment().getCustomer().getProfile().getLastName()
				+ " "
				+ billing.getCustomerContract().getBookingApartment()
						.getCustomer().getProfile().getFirstName());

		return billingDto;
	}

	public static List<BillingDto> map(List<Billing> listBilling)
	{
		List<BillingDto> billingDtos = new ArrayList<>();
		for ( Billing billing : listBilling )
		{
			billingDtos.add(map(billing));
		}
		return billingDtos;
	}
}
