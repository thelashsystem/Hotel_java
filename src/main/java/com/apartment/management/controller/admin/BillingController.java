package com.apartment.management.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apartment.management.model.business.Billing;
import com.apartment.management.model.business.ResourceBilling;
import com.apartment.management.model.contract.CustomerContract;
import com.apartment.management.response.DatatableResponse;
import com.apartment.management.response.StatusResponse;
import com.apartment.management.response.dto.BillingDto;
import com.apartment.management.response.dto.DetailBillingDto;
import com.apartment.management.service.interfaces.business.BillingService;
import com.apartment.management.service.interfaces.business.ResourceBillingService;
import com.apartment.management.service.interfaces.business.ApartmentBillingService;
import com.apartment.management.service.interfaces.contract.CustomerContractService;

@Controller
@RequestMapping(value = "billing")
public class BillingController
{
	@Autowired
	private BillingService billingService;

	@Autowired
	private ApartmentBillingService apartmentBillingService;

	@Autowired
	private ResourceBillingService resourceBillingService;

	@Autowired
	private CustomerContractService customerContractService;

	@RequestMapping(value = "billing-list", method = RequestMethod.GET)
	public String doView(Model m)
	{
		return "billing-list";
	}

	@RequestMapping(value = "sub-billing-detail", method = RequestMethod.GET)
	public String doSubDetailView(Model m)
	{
		return "sub-detail-billing";
	}

	@RequestMapping(value = "pending-billing-list", method = RequestMethod.GET)
	public String doPendingBillingView(Model m)
	{
		// System.out.println(roomBillingService.getAll().size());
		for ( CustomerContract customerContract : customerContractService
				.getAll() )
		{
			billingService.createdBilling(customerContract);
		}
		System.out.println(billingService.getAll().size());
		return "pending-billing-list";
	}

	@RequestMapping(value = "resource-pending-billing-list", method = RequestMethod.GET)
	public String doPendingResourceBillingView(Model m)
	{
		return "resource-pending-billing-list";
	}

	@RequestMapping(value = "detail-billing", params = "id", method = RequestMethod.GET)
	public String doDetailView(@RequestParam(value = "id") String id, Model m)
	{
		Billing billing = billingService.getById(Integer.parseInt(id));
		m.addAttribute("billing", billing);
		return "detail-billing";
	}

	@RequestMapping(value = "getResouceBilling", params = "billingId", method = RequestMethod.GET)
	@ResponseBody
	private DatatableResponse<DetailBillingDto> getResouceBilling(
			@RequestParam(value = "billingId") String billingId)
	{
		DatatableResponse<DetailBillingDto> response = new DatatableResponse<>();
		List<ResourceBilling> resouceBilling = resourceBillingService.getAll();
		List<DetailBillingDto> detailBillingDto = DetailBillingDto
				.map(resouceBilling);
		response.setAaData(detailBillingDto);
		return response;
	}

	@RequestMapping(value = "getAllPendingBilling", method = RequestMethod.GET)
	@ResponseBody
	private DatatableResponse<BillingDto> getAllPendingBilling()
	{
		DatatableResponse<BillingDto> response = new DatatableResponse<>();
		List<Billing> listBilling = billingService.getAll();
		List<BillingDto> listBillingDto = BillingDto.map(listBilling);
		response.setAaData(listBillingDto);
		return response;
	}

	@RequestMapping(value = "getAllBilling", method = RequestMethod.GET)
	@ResponseBody
	private DatatableResponse<BillingDto> getAllBilling()
	{
		DatatableResponse<BillingDto> response = new DatatableResponse<>();
		List<Billing> listBilling = billingService.getAll();
		List<BillingDto> listBillingDto = BillingDto.map(listBilling);
		response.setAaData(listBillingDto);
		return response;
	}

	@RequestMapping(value = "addBilling", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Billing> doAdd()
	{
		return new StatusResponse<Billing>();
	}

	@RequestMapping(value = "updateBilling", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Billing> doUpdate()
	{
		return new StatusResponse<Billing>();
	}

	@RequestMapping(value = "deleteBilling", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Billing> doDelete()
	{
		return new StatusResponse<Billing>();
	}
}
