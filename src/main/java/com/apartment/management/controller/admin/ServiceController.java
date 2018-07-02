package com.apartment.management.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apartment.management.model.building.Service;
import com.apartment.management.response.DatatableResponse;
import com.apartment.management.response.StatusResponse;
import com.apartment.management.response.dto.ServiceDto;
import com.apartment.management.service.interfaces.building.ServiceService;

@Controller
@RequestMapping(value = "service")
public class ServiceController
{
	@Autowired
	private ServiceService serviceService;

	@RequestMapping(value = "service-list", method = RequestMethod.GET)
	private String getAllRoomType(Model m)
	{
		return "service-list";
	}

	@RequestMapping(value = "service-price-plan", method = RequestMethod.GET)
	private String doServicePricePlanView()
	{
		return "service-price-plan";
	}

	@RequestMapping(value = "service-detail", method = RequestMethod.GET)
	private String doDetailEmployeeView()
	{
		return "service-detail";
	}

	@RequestMapping(value = "getAllService", method = RequestMethod.GET)
	@ResponseBody
	private DatatableResponse<ServiceDto> getAllService()
	{
		DatatableResponse<ServiceDto> response = new DatatableResponse<>();
		List<Service> listService = serviceService.getAll();
		List<ServiceDto> listServiceDto = ServiceDto.map(listService);
		response.setAaData(listServiceDto);
		return response;
	}

	@RequestMapping(value = "addService", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Service> doAdd()
	{
		return new StatusResponse<Service>();
	}

	@RequestMapping(value = "updateService", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Service> doUpdate()
	{
		return new StatusResponse<Service>();
	}

	@RequestMapping(value = "deleteService", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Service> doDelete()
	{
		return new StatusResponse<Service>();
	}
}
