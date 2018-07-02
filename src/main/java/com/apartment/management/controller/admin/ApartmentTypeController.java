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

import com.apartment.management.model.building.ApartmentType;
import com.apartment.management.response.DatatableResponse;
import com.apartment.management.response.StatusResponse;
import com.apartment.management.response.dto.ApartmentTypeDto;
import com.apartment.management.service.interfaces.building.ApartmentService;
import com.apartment.management.service.interfaces.building.ApartmentTypeService;

@Controller
@RequestMapping(value = "apartment-type")
public class ApartmentTypeController
{
	@Autowired
	private ApartmentService apartmentService;

	@Autowired
	private ApartmentTypeService apartmentTypeService;

	@RequestMapping(value = "apartment-type-list", method = RequestMethod.GET)
	public String doView()
	{
		return "apartment-type-list";
	}

	@RequestMapping(value = "apartment-type-detail", params="id", method = RequestMethod.GET)
	public String doDetailView(@RequestParam(value="id")String id, Model m)
	{
		ApartmentType apartmentType = apartmentTypeService.getById(Short.parseShort(id));
		m.addAttribute("apartmentType", apartmentType);
		return "apartment-type-detail";
	}
	
	@RequestMapping(value = "apartment-type-detail", method = RequestMethod.POST)
	public String doDetailView(@ModelAttribute(value="apartmentType")ApartmentType apartmentType, BindingResult rs, Model m)
	{
		if (!rs.hasErrors()) {
			apartmentTypeService.update(apartmentType);
		} else {
			return "apartment-type-detail";
		}
		return "apartment-type-detail";
	}

	@RequestMapping(value = "getAllApartmentType", method = RequestMethod.GET)
	@ResponseBody
	private DatatableResponse<ApartmentTypeDto> getAllApartmentType()
	{
		DatatableResponse<ApartmentTypeDto> response = new DatatableResponse<>();
		List<ApartmentType> listApartmentType = apartmentTypeService.getAll();
		List<ApartmentTypeDto> listApartmentTypeDto = ApartmentTypeDto
				.map(listApartmentType);
		response.setAaData(listApartmentTypeDto);
		return response;
	}
	
	@RequestMapping(value = "getApartmentTypeById", params="id", method = RequestMethod.GET)
	@ResponseBody
	private StatusResponse<ApartmentType> getApartmentTypeById(@RequestParam(value="id")String id)
	{
		ApartmentType apartmentType = apartmentTypeService.getById(Short.parseShort(id));
		StatusResponse<ApartmentType> response = new StatusResponse<>(true);
		response.setObject(apartmentType);
		return response;
	}

	@RequestMapping(value = "addApartmentType", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<ApartmentType> doAdd(ApartmentType apartmentType)
	{
		apartmentTypeService.add(apartmentType);
		return new StatusResponse<ApartmentType>(true);
	}

	@RequestMapping(value = "updateApartmentType", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<ApartmentType> doUpdate()
	{
		return new StatusResponse<ApartmentType>();
	}

	@RequestMapping(value = "deleteApartmentType", params="id", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<ApartmentType> doDelete(@RequestParam(value="id")String id)
	{
		ApartmentType apartmentType = apartmentTypeService.getById(Short.parseShort(id));
		apartmentTypeService.delete(apartmentType);
		return new StatusResponse<ApartmentType>(true);
	}
}
