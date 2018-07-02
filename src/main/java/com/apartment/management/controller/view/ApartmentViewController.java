package com.apartment.management.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apartment.management.model.asset.ApartmentEquipment;
import com.apartment.management.model.building.Apartment;
import com.apartment.management.model.building.ApartmentType;
import com.apartment.management.service.interfaces.asset.ApartmentEquipmentService;
import com.apartment.management.service.interfaces.building.ApartmentService;
import com.apartment.management.service.interfaces.building.ApartmentTypeService;

@Controller
public class ApartmentViewController
{
	@Autowired
	private ApartmentService apartmentService;

	@Autowired
	private ApartmentTypeService apartmentTypeService;

	@Autowired
	private ApartmentEquipmentService apartmentEquipmentService;

	@RequestMapping(value = "Apartment-Type/{apartmentTypeName}-{apartmentTypeId}/Apartment/{apartmentName}-{apartmentId}/apartment-detail", method = RequestMethod.GET)
	private String doViewApartmentDetail(Model m,
			@PathVariable(value = "apartmentTypeId") String apartmentTypeId,
			@PathVariable(value = "apartmentId") String apartmentId)
	{
		List<ApartmentType> listApartmentType = apartmentTypeService
				.getAllApartmentType();
		Apartment apartment = apartmentService.getById(Integer
				.parseInt(apartmentId));
		List<Apartment> listRandomApartment = apartmentService
				.get3RandomApartmentFromApartmentType(apartment
						.getApartmentType());
		m.addAttribute("apartment", apartment);
		m.addAttribute("listApartmentType", listApartmentType);
		m.addAttribute("listRandomApartment", listRandomApartment);
		List<ApartmentEquipment> listFacility = apartmentEquipmentService
				.getUnhiddenEquipmentInApartment(apartment);
		m.addAttribute("listFacility", listFacility);
		return "apartment-detail";
	}

	@RequestMapping(value = "apartment-list", method = RequestMethod.GET)
	private String doViewApartmentList(Model m)
	{
		getDefaultData(m);
		List<Apartment> listApartment = apartmentService.getAvailableApartment();
		m.addAttribute("listApartment", listApartment);
		return "apartment-list";
	}

	@RequestMapping(value = "apartment-detail", method = RequestMethod.GET)
	private String doViewApartmentDetail(Model m)
	{
		getDefaultData(m);
		return "redirect:apartment-list";
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
