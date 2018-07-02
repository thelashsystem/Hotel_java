package com.apartment.management.controller.view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apartment.management.model.building.Apartment;
import com.apartment.management.model.building.ApartmentType;
import com.apartment.management.model.building.Building;
import com.apartment.management.model.street.City;
import com.apartment.management.response.SearchRequest;
import com.apartment.management.service.interfaces.building.ApartmentService;
import com.apartment.management.service.interfaces.building.ApartmentTypeService;
import com.apartment.management.service.interfaces.building.BuildingService;
import com.apartment.management.service.interfaces.street.CityService;

@Controller
public class SearchController
{
	@Autowired
	private CityService cityService;

	@Autowired
	private BuildingService buildingService;

	@Autowired
	private ApartmentTypeService apartmentTypeService;

	@Autowired
	private ApartmentService apartmentService;

	@RequestMapping(value = "/search-apartment", method = RequestMethod.GET)
	public String doView(Model m)
	{
		getDefaultInfo(m);
		return "search-apartment";
	}

	@RequestMapping(value = "/search-apartment", method = RequestMethod.POST)
	public String doSearchView(SearchRequest search, Model m,
			HttpServletRequest request)
	{
		City city = null;
		Building building = null;
		ApartmentType apartmentType = null;

		if ( search.getCityId() != 0 )
		{
			city = cityService.getById(search.getCityId());
		}

		if ( search.getBuildingId() != 0 )
		{
			building = buildingService.getById(search.getBuildingId());
		}

		if ( search.getApartmentTypeId() != 0 )
		{
			apartmentType = apartmentTypeService.getById(search
					.getApartmentTypeId());
		}
		PageRequest paging;
		if (search.getPriceSort() == 0) {
			paging = new PageRequest(0, 12, new Sort(new Order(Direction.ASC, "apartmentType.price")));
		} else {
			paging = new PageRequest(0, 12, new Sort(new Order(Direction.DESC, "apartmentType.price")));
		}
		
		Page<Apartment> listApartment = null;
		if ( city != null && building == null && apartmentType != null )
		{
			listApartment = apartmentService.findByCityAndApartmentType(city,
					apartmentType, search.getPriceRange(), search.getNumGuest(), paging);
		} else if ( building != null && apartmentType != null )
		{
			listApartment = apartmentService.findByBuildingAndApartmentType(
					building, apartmentType, search.getPriceRange(), search.getNumGuest(), paging);
		} else if ( building == null && apartmentType != null )
		{
			listApartment = apartmentService.findByApartmentType(apartmentType, search.getPriceRange(), search.getNumGuest(),
					paging);
		} else if ( building != null )
		{
			listApartment = apartmentService.findByBuilding(building, search.getPriceRange(), search.getNumGuest(), paging);
		} else if (city != null) {
			listApartment = apartmentService.findByCity(city, search.getPriceRange(), search.getNumGuest(), paging);
		} else
		{
			listApartment = apartmentService.findAll(search.getPriceRange(), search.getNumGuest(), paging);
		}
		
		String url = request.getQueryString();
		m.addAttribute("url", url);
		m.addAttribute("listApartment", listApartment);
		getDefaultInfo(m);
		return "search-apartment";
	}

	@RequestMapping(value = "/search-apartment", params = "page", method = RequestMethod.POST)
	public String doSearchViewByPage(SearchRequest search,
			@RequestParam(value = "page") String page, Model m,
			HttpServletRequest request)
	{
		City city = null;
		Building building = null;
		ApartmentType apartmentType = null;

		if ( search.getCityId() != 0 )
		{
			city = cityService.getById(search.getCityId());
		}

		if ( search.getBuildingId() != 0 )
		{
			building = buildingService.getById(search.getBuildingId());
		}

		if ( search.getApartmentTypeId() != 0 )
		{
			apartmentType = apartmentTypeService.getById(search
					.getApartmentTypeId());
		}

		PageRequest paging = new PageRequest(Integer.parseInt(page) - 1, 12);
		Page<Apartment> listApartment = null;
//		if ( city != null && building == null )
//		{
//			listApartment = apartmentService.findByCityAndApartmentType(city,
//					apartmentType, paging);
//		} else if ( building != null )
//		{
//			listApartment = apartmentService.findByBuildingAndApartmentType(
//					building, apartmentType, paging);
//		}
		String url = request.getQueryString();
		m.addAttribute("url", url);
		m.addAttribute("listApartment", listApartment);
		getDefaultInfo(m);
		return "search-apartment";
	}

	private void getDefaultInfo(Model m)
	{
		List<City> listCity = cityService.getAll();
		List<ApartmentType> listApartmentType = apartmentTypeService.getAll();
		List<Building> listBuilding = buildingService.getAll();
		m.addAttribute("listCity", listCity);
		m.addAttribute("listApartmentType", listApartmentType);
		m.addAttribute("listBuilding", listBuilding);
	}
}
