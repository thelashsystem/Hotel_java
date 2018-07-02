package com.apartment.management.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apartment.management.model.person.Customer;
import com.apartment.management.response.DatatableResponse;
import com.apartment.management.response.StatusResponse;
import com.apartment.management.response.dto.CustomerDto;
import com.apartment.management.service.interfaces.person.CustomerService;

@Controller
@RequestMapping(value = "customer")
public class CustomerController
{
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "customer-list", method = RequestMethod.GET)
	private String doView(Model m)
	{
		return "customer-list";
	}

	@RequestMapping(value = "customer-detail", params = "id", method = RequestMethod.GET)
	private String doDetailCustomerView(Model m,
			@RequestParam(value = "id") String id)
	{
		Customer customer = customerService.getById(Integer.parseInt(id));
		m.addAttribute("customer", customer);
		return "customer-detail";
	}

	@RequestMapping(value = "customer-detail", method = RequestMethod.POST)
	private String doUpdateDetailCustomerView(
			@ModelAttribute(value = "customer") Customer customer,
			BindingResult rs)
	{
		if (!rs.hasErrors()) {
			customerService.update(customer);
		} else {
			return "customer-detail";
		}
		return "customer-detail";
	}

	@RequestMapping(value = "customer-detail", method = RequestMethod.GET)
	private String doDetailCustomerView()
	{
		return "redirect:management/customer/customer-list";
	}

	@RequestMapping(value = "getAllCustomer", method = RequestMethod.GET)
	@ResponseBody
	private DatatableResponse<CustomerDto> getAllCustomer()
	{
		DatatableResponse<CustomerDto> response = new DatatableResponse<>();
		List<Customer> listCus = customerService.getAll();
		List<CustomerDto> listCusDto = CustomerDto.map(listCus);
		response.setAaData(listCusDto);
		return response;
	}

	@RequestMapping(value = "addCustomer", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Customer> doAdd()
	{
		return new StatusResponse<Customer>();
	}

	@RequestMapping(value = "updateCustomer", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Customer> doUpdate()
	{
		return new StatusResponse<Customer>();
	}

	@RequestMapping(value = "deleteCustomer", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Customer> doDelete()
	{
		return new StatusResponse<Customer>();
	}

}
