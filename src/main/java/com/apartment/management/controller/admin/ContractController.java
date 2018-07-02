package com.apartment.management.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apartment.management.model.contract.Contract;
import com.apartment.management.model.contract.CustomerContract;
import com.apartment.management.response.DatatableResponse;
import com.apartment.management.response.StatusResponse;
import com.apartment.management.response.dto.CustomerContractDto;
import com.apartment.management.service.interfaces.account.EmployeeAccountService;
import com.apartment.management.service.interfaces.contract.AdvertisingContractService;
import com.apartment.management.service.interfaces.contract.CustomerContractService;
import com.apartment.management.service.interfaces.contract.ServiceContractService;
import com.apartment.management.service.interfaces.contract.SupplierContractService;

@Controller
@RequestMapping("contract")
public class ContractController
{
	@Autowired
	private CustomerContractService customerContractService;

	@Autowired
	private EmployeeAccountService employeeAccountService;

	@Autowired
	private SupplierContractService supplierContractService;

	@Autowired
	private AdvertisingContractService advertisingContractService;

	@Autowired
	private ServiceContractService serviceContractService;

	@RequestMapping(value = "customer-contract", method = RequestMethod.GET)
	public String doCustomerContractView()
	{
		return "customer-contract";
	}

	@RequestMapping(value = "service-contract", method = RequestMethod.GET)
	public String doServiceContractView()
	{
		return "service-contract";
	}

	@RequestMapping(value = "employee-contract", method = RequestMethod.GET)
	public String doEmployeeContractView()
	{
		return "employee-contract";
	}

	@RequestMapping(value = "supplier-contract", method = RequestMethod.GET)
	public String doSupplierContractView()
	{
		return "supplier-contract";
	}

	@RequestMapping(value = "advertising-contract", method = RequestMethod.GET)
	public String doAdvertisingContractView()
	{
		return "advertising-contract";
	}

	@RequestMapping(value = "getAllContract", method = RequestMethod.GET)
	@ResponseBody
	private DatatableResponse<CustomerContractDto> getAllContract()
	{
		DatatableResponse<CustomerContractDto> response = new DatatableResponse<>();
		// List<Contract> listContract = contractService.getAll();
		// List<ContractDto> listContractDto = ContractDto.map(listContract);
		// response.setAaData(listContractDto);

		return response;
	}

	@RequestMapping(value = "getAllCustomerContract", method = RequestMethod.GET)
	@ResponseBody
	private DatatableResponse<CustomerContractDto> getAllCustomerContract()
	{
		DatatableResponse<CustomerContractDto> response = new DatatableResponse<>();
		 List<CustomerContract> listContract = customerContractService.getAll();
		 List<CustomerContractDto> listContractDto = CustomerContractDto.map(listContract);
		 response.setAaData(listContractDto);
		return response;
	}

	@RequestMapping(value = "addContract", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Contract> doAdd()
	{
		return new StatusResponse<Contract>();
	}

	@RequestMapping(value = "updateContract", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Contract> doUpdate()
	{
		return new StatusResponse<Contract>();
	}

	@RequestMapping(value = "deleteContract", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Contract> doDelete()
	{
		return new StatusResponse<Contract>();
	}

}
