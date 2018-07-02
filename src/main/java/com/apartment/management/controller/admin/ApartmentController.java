package com.apartment.management.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apartment.management.model.building.Apartment;
import com.apartment.management.model.building.ApartmentType;
import com.apartment.management.model.building.Building;
import com.apartment.management.model.building.Floor;
import com.apartment.management.response.DatatableResponse;
import com.apartment.management.response.StatusResponse;
import com.apartment.management.response.dto.ApartmentDto;
import com.apartment.management.service.interfaces.building.ApartmentService;
import com.apartment.management.service.interfaces.building.ApartmentTypeService;
import com.apartment.management.service.interfaces.building.BuildingService;
import com.apartment.management.service.interfaces.building.FloorService;

@Controller
@RequestMapping(value = "apartment")
public class ApartmentController
{
	@Autowired
	private ApartmentService apartmentService;
	
	@Autowired
	private BuildingService buildingService;
	
	@Autowired
	private FloorService floorService;
	
	@Autowired
	private ApartmentTypeService apartmentTypeService;

	@RequestMapping(value = "apartment-list", method = RequestMethod.GET)
	private String doView(Model m)
	{
		List<Building> listBuilding = buildingService.getAll();
		List<ApartmentType> listApartmentType = apartmentTypeService.getAll();
		List<Floor> listFloor = floorService.getAll();
		m.addAttribute("listBuilding", listBuilding);
		m.addAttribute("listApartmentType", listApartmentType);
		m.addAttribute("listFloor", listFloor);
		return "apartment-list";
	}
	
	@RequestMapping(value="getFloorInBuilding", method=RequestMethod.GET, params="buildingId")
	@ResponseBody
	public StatusResponse<Floor> getFloorInBuilding(@RequestParam(value="buildingId")String buildingId) {
		Building building = buildingService.getById(Short.parseShort(buildingId));
		List<Floor> listFloor = floorService.getFloorByBuilding(building);
		StatusResponse<Floor> status = new StatusResponse<>(true);
		status.setObjects(listFloor);
		return status;
	}
	
	@RequestMapping(value = "apartment-detail", method = RequestMethod.GET)
	private String doDetailApartmentView()
	{
		return "redirect:apartment-list";
	}

	@RequestMapping(value = "apartment-detail", params="id", method = RequestMethod.GET)
	private String doDetailApartmentView(@RequestParam(value="id")String id, Model m)
	{
		Apartment apartment = apartmentService.getById(Integer.parseInt(id));
		List<Building> listBuilding = buildingService.getAll();
		List<ApartmentType> listApartmentType = apartmentTypeService.getAll();
		List<Floor> listFloor = floorService.getAll();
		m.addAttribute("listBuilding", listBuilding);
		m.addAttribute("listApartmentType", listApartmentType);
		m.addAttribute("listFloor", listFloor);
		m.addAttribute("apartment", apartment);
		return "apartment-detail";
	}
	
	@RequestMapping(value = "apartment-detail", method = RequestMethod.POST)
	private String doDetailApartmentView(@ModelAttribute(value="apartment") Apartment apartment, BindingResult rs, Model m)
	{
		if (!rs.hasErrors()) {
			apartmentService.update(apartment);
		} else {
			return "apartment-detail";
		}
		return "redirect:/apartment-detail.html?id=" + apartment.getId();
	}
	
	@RequestMapping(value = "getApartmentById", params="id", method = RequestMethod.GET)
	@ResponseBody
	private StatusResponse<Apartment> getApartmentById(@RequestParam(value="id")String id)
	{
		StatusResponse<Apartment> response = new StatusResponse<>(true);
		Apartment apartment = apartmentService.getById(Integer.parseInt(id));
		response.setObject(apartment);
		return response;
	}

	@RequestMapping(value = "getAllApartment", method = RequestMethod.GET)
	@ResponseBody
	private DatatableResponse<ApartmentDto> getAllApartment()
	{
		DatatableResponse<ApartmentDto> response = new DatatableResponse<>();
		List<Apartment> listApartment = apartmentService.getAll();
		List<ApartmentDto> listApartmentDto = ApartmentDto.map(listApartment);
		response.setAaData(listApartmentDto);
		return response;
	}
	

	@RequestMapping(value = "addApartment", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Floor> addApartment(Apartment apartment, BindingResult rs)
	{
		if (!rs.hasErrors()) {
			Floor floor = floorService.getById(apartment.getFloor().getId());
			apartment.setFloor(null);
			ApartmentType apartmentType = apartmentTypeService.getById(apartment.getApartmentType().getId());
			apartment.setApartmentType(null);
			apartmentService.add(apartment);
			apartment.setFloor(floor);
			apartment.setApartmentType(apartmentType);
			apartment.setStatus(0);
			apartmentService.update(apartment);
		} else {
			 StatusResponse<Floor> status = new StatusResponse<Floor>(false);
			 for (ObjectError err: rs.getAllErrors()) {
				 status.addMessage(err.getDefaultMessage());
			 }
			return status;
		}
		return new StatusResponse<Floor>(true);
	}

	@RequestMapping(value = "updateApartment", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Floor> updateApartment(Apartment apartment, BindingResult rs)
	{
		if (!rs.hasErrors()) {
			Floor floor = floorService.getById(apartment.getFloor().getId());
			ApartmentType apartmentType = apartmentTypeService.getById(apartment.getApartmentType().getId());
			apartment.setFloor(floor);
			apartment.setApartmentType(apartmentType);
			apartmentService.update(apartment);
//			apartment = apartmentService.getById(apartment.getId());
//			apartment.setFloor(floor);
//			apartment.setApartmentType(apartmentType);
//			apartmentService.update(apartment);
		} else {
			
		}
		return new StatusResponse<Floor>(true);
	}

	@RequestMapping(value = "deleteApartment", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Floor> deleteApartment(@RequestParam(value="id")String id)
	{
		Apartment apartment = apartmentService.getById(Integer.parseInt(id));
		apartmentService.delete(apartment);
		return new StatusResponse<Floor>(true);
	}
}
