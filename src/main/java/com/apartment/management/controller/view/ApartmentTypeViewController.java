package com.apartment.management.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apartment.management.model.building.Apartment;
import com.apartment.management.model.building.ApartmentType;
import com.apartment.management.service.interfaces.building.ApartmentService;
import com.apartment.management.service.interfaces.building.ApartmentTypeService;

@Controller
public class ApartmentTypeViewController
{
	@Autowired
	private ApartmentTypeService apartmentTypeService;

	@Autowired
	private ApartmentService apartmentService;

	@RequestMapping(value = "Apartment-Type/{apartmentName}-{apartmentId}/apartment-list", method = RequestMethod.GET)
	private String doViewApartmentTypeList(Model m)
	{
		List<Apartment> listApartment = apartmentService.getAllApartment();
		List<ApartmentType> listApartmentType = apartmentTypeService
				.getAllApartmentType();
		m.addAttribute("listApartmentType", listApartmentType);
		m.addAttribute("listApartment", listApartment);
		return "apartment-list";
	}
}
