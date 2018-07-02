package com.apartment.management.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apartment.management.model.building.ApartmentType;
import com.apartment.management.model.building.Building;
import com.apartment.management.service.interfaces.building.ApartmentTypeService;
import com.apartment.management.service.interfaces.building.BuildingService;

@Controller
public class ContactController
{
	@Autowired
	private ApartmentTypeService apartmentTypeService;
	
	@Autowired
	private BuildingService buildingService;

	@RequestMapping(value = "contact", method = RequestMethod.GET)
	private String doViewContact(Model m)
	{
		getDefaultData(m);
		List<Building> listBuilding = buildingService.getAll();
		m.addAttribute("listBuilding", listBuilding);
		return "contact";
	}

	@RequestMapping(value = "about-us", method = RequestMethod.GET)
	private String doAboutUsView(Model m)
	{
		getDefaultData(m);
		return "about-us";
	}

	@RequestMapping(value = "sendMessage", method = RequestMethod.POST)
	public String doView(Model m)
	{
		return "contact";
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
