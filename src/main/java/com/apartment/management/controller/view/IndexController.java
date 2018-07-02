package com.apartment.management.controller.view;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apartment.management.model.building.Apartment;
import com.apartment.management.model.building.ApartmentType;
import com.apartment.management.model.building.Building;
import com.apartment.management.model.news.News;
import com.apartment.management.model.street.City;
import com.apartment.management.service.interfaces.building.ApartmentService;
import com.apartment.management.service.interfaces.building.ApartmentTypeService;
import com.apartment.management.service.interfaces.building.BuildingService;
import com.apartment.management.service.interfaces.news.NewsService;
import com.apartment.management.service.interfaces.street.CityService;

@Controller
public class IndexController
{
	@Autowired
	private ApartmentTypeService apartmentTypeService;

	@Autowired
	private ApartmentService apartmentService;

	@Autowired
	private CityService cityService;

	@Autowired
	private BuildingService buildingService;
	
	@Autowired
	private NewsService newsService;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	private String doViewIndex(Model m)
	{
		getDefaultData(m);
		List<City> listCity = cityService.getAll();
		m.addAttribute("listCity", listCity);
		List<Building> listBuilding = buildingService.getAll();
		m.addAttribute("listBuilding", listBuilding);
		List<ApartmentType> listApartmentType = apartmentTypeService.get3HighestApartmentType();
		List<Apartment> listApartment = new ArrayList<>();
		for (ApartmentType apartmentType: listApartmentType) {
			listApartment.add(apartmentService.getRandomApartmentFromApartmentType(apartmentType));
		}
		m.addAttribute("listApartment", listApartment);
		return "index";
	}

	@RequestMapping(value = "gallery", method = RequestMethod.GET)
	private String doViewGallery(Model m)
	{
		getDefaultData(m);
		return "gallery";
	}

	@RequestMapping(value = "*", method = RequestMethod.GET)
	private String doViewError404(Model m)
	{
		getDefaultData(m);
		return "404";
	}

	@RequestMapping(value = "404", method = RequestMethod.GET)
	private String doView404(Model m)
	{
		getDefaultData(m);
		return "404";
	}

	private void getDefaultData(Model m)
	{
		String language = LocaleContextHolder.getLocale().getLanguage();
		List<ApartmentType> listApartmentType = apartmentTypeService
				.getAllApartmentType();
		List<News> list3LastestNews = newsService.get3LastestNews();
		m.addAttribute("listApartmentType", listApartmentType);
		m.addAttribute("language", language);
		m.addAttribute("list3LastestNews", list3LastestNews);
	}
}
