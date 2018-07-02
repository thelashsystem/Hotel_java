package com.apartment.management.response.dto;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.apartment.management.model.business.BillingDetail;
import com.apartment.management.model.business.ResourceBilling;
import com.apartment.management.model.business.ApartmentBilling;
import com.apartment.management.model.business.ServiceBilling;

public class DetailBillingDto
{
	private Long id;
	private String name;
	private Double price;
	private String status;
	private String typeBilling;
	private String updatedPriceDate;
	private Integer quantity;
	private Double defaultPrice;
	@Autowired
	@Qualifier(value = "ddMMyyyy")
	private SimpleDateFormat dateFormat;

	public DetailBillingDto()
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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Double getPrice()
	{
		return price;
	}

	public void setPrice(Double price)
	{
		this.price = price;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getTypeBilling()
	{
		return typeBilling;
	}

	public void setTypeBilling(String typeBilling)
	{
		this.typeBilling = typeBilling;
	}

	public String getUpdatedPriceDate()
	{
		return updatedPriceDate;
	}

	public void setUpdatedPriceDate(Date updatedPriceDate)
	{
		this.updatedPriceDate = dateFormat.format(updatedPriceDate);
	}

	public Integer getQuantity()
	{
		return quantity;
	}

	public void setQuantity(Integer quantity)
	{
		this.quantity = quantity;
	}

	public Double getDefaultPrice()
	{
		return defaultPrice;
	}

	public void setDefaultPrice(Double defaultPrice)
	{
		this.defaultPrice = defaultPrice;
	}

	public void setUpdatedPriceDate(String updatedPriceDate)
	{
		this.updatedPriceDate = updatedPriceDate;
	}

	public static DetailBillingDto map(BillingDetail billingDetail)
	{
		DetailBillingDto detailBillingDto = new DetailBillingDto();
		detailBillingDto.setId(billingDetail.getId());
		billingDetail.setSubPrice(billingDetail.getSubPrice());
		if ( billingDetail instanceof ResourceBilling )
		{
			ResourceBilling resourceBilling = (ResourceBilling) billingDetail;
			detailBillingDto.setName(resourceBilling.getResourcePrice()
					.getResource().getName());
			detailBillingDto.setTypeBilling("Resource");
			detailBillingDto.setUpdatedPriceDate(resourceBilling
					.getResourcePrice().getUpdatedDate());
			detailBillingDto.setDefaultPrice(resourceBilling.getResourcePrice()
					.getPrice());
			detailBillingDto.setQuantity(resourceBilling.getQuantity());
		} else if ( billingDetail instanceof ServiceBilling )
		{
			ServiceBilling serviceBilling = (ServiceBilling) billingDetail;
			detailBillingDto.setName(serviceBilling.getServicePrice()
					.getService().getName());
			detailBillingDto.setTypeBilling("Service");
			detailBillingDto.setUpdatedPriceDate(serviceBilling
					.getServicePrice().getUpdateDate());
			detailBillingDto.setDefaultPrice(serviceBilling.getServicePrice()
					.getPrice());
		} else if ( billingDetail instanceof ApartmentBilling )
		{
			detailBillingDto.setName(billingDetail.getBilling()
					.getCustomerContract().getBookingApartment().getApartment()
					.getName());
			detailBillingDto.setTypeBilling("Apartment");
			detailBillingDto
					.setUpdatedPriceDate(((ApartmentBilling) billingDetail)
							.getApartmentTypePrice().getUpdatedDate());
			detailBillingDto.setDefaultPrice(((ApartmentBilling) billingDetail)
					.getApartmentTypePrice().getPrice());
		}
		return detailBillingDto;
	}

	public static List<DetailBillingDto> map(
			List<ResourceBilling> listBillingDetail)
	{
		List<DetailBillingDto> listDetailBillingDto = new ArrayList<>();
		for ( BillingDetail billingDetail : listBillingDetail )
		{
			listDetailBillingDto.add(map(billingDetail));
		}
		return listDetailBillingDto;
	}

}
