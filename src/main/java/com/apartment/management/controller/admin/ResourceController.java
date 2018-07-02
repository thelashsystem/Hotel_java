package com.apartment.management.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apartment.management.model.business.Resource;
import com.apartment.management.response.DatatableResponse;
import com.apartment.management.response.StatusResponse;
import com.apartment.management.response.dto.ResourceDto;
import com.apartment.management.service.interfaces.business.ResourceService;

@Controller
@RequestMapping("resource")
public class ResourceController
{
	@Autowired
	private ResourceService resourceService;

	@RequestMapping(value = "resource-list", method = RequestMethod.GET)
	public String doView()
	{
		return "resource-list";
	}

	@RequestMapping(value = "resource-price-plan", method = RequestMethod.GET)
	public String doResourcePricePlanView()
	{
		return "resource-price-plan";
	}

	@RequestMapping(value = "getAllResource", method = RequestMethod.GET)
	@ResponseBody
	public DatatableResponse<ResourceDto> getAllResource()
	{
		DatatableResponse<ResourceDto> response = new DatatableResponse<>();
		List<Resource> resources = resourceService.getAll();
		List<ResourceDto> listResourceDto = ResourceDto.map(resources);
		response.setAaData(listResourceDto);
		return response;
	}

	@RequestMapping(value = "addResource", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Resource> addResource()
	{
		return new StatusResponse<Resource>();
	}

	@RequestMapping(value = "updateResource", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Resource> updateResource()
	{
		return new StatusResponse<Resource>();
	}

	@RequestMapping(value = "deleteResource", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Resource> deleteResource()
	{
		return new StatusResponse<Resource>();
	}
}
