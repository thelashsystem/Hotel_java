package com.apartment.management.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apartment.management.model.building.ApartmentType;
import com.apartment.management.model.building.Service;
import com.apartment.management.service.interfaces.building.ApartmentTypeService;
import com.apartment.management.service.interfaces.building.ServiceService;

@Controller
public class ServiceViewController
{
	@Autowired
	private ApartmentTypeService apartmentTypeService;
	
	@Autowired
	private ServiceService serviceService;

	@RequestMapping(value = "service-list", method = RequestMethod.GET)
	private String doViewService(Model m)
	{
		getDefaultData(m);
		List<Service> listService = serviceService.getAll();
		m.addAttribute("listService", listService);
		return "service-list";
	}

	@RequestMapping(value = "service-detail", method = RequestMethod.GET)
	private String doViewServiceDetail(Model m)
	{
		getDefaultData(m);
		return "redirect:service-list.html";
	}
	
	@RequestMapping(value = "Service/{serviceName}-{serviceId}/service-detail", method = RequestMethod.GET)
	private String doViewServiceDetail(@PathVariable(value="serviceName")String serviceName, @PathVariable(value="serviceId")String serviceId, Model m)
	{
		getDefaultData(m);
		return "service-detail";
	}

	private void getDefaultData(Model m)
	{
		String language = LocaleContextHolder.getLocale().getLanguage();
		List<ApartmentType> listApartmentType = apartmentTypeService
				.getAllApartmentType();
		m.addAttribute("listApartmentType", listApartmentType);
		m.addAttribute("language", language);
	}

}
