package com.apartment.management.controller.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apartment.management.model.building.Building;
import com.apartment.management.model.building.Floor;
import com.apartment.management.model.person.Employee;
import com.apartment.management.model.street.City;
import com.apartment.management.model.street.District;
import com.apartment.management.response.DatatableResponse;
import com.apartment.management.response.StatusResponse;
import com.apartment.management.response.dto.BuildingDto;
import com.apartment.management.response.dto.EmployeeDto;
import com.apartment.management.response.dto.FloorDto;
import com.apartment.management.service.interfaces.building.BuildingService;
import com.apartment.management.service.interfaces.building.FloorService;
import com.apartment.management.service.interfaces.person.EmployeeService;
import com.apartment.management.service.interfaces.street.CityService;
import com.apartment.management.service.interfaces.street.DistrictService;

@Controller
@RequestMapping(value = "building")
public class BuildingController
{
	@Autowired
	private BuildingService buildingService;

	@Autowired
	private CityService cityService;

	@Autowired
	private DistrictService districtService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private FloorService floorService;
	
	

	// @Autowired
	// JqgridResponse<BuildingDto> response;

	@RequestMapping(value = "building-list", method = RequestMethod.GET)
	private String doView(Model m)
	{
		List<City> listCity = cityService.getAll();
		List<District> listDistrict = districtService.getAll();
		m.addAttribute("listCity", listCity);
		m.addAttribute("listDistrict", listDistrict);
		return "building-list";
	}

	@RequestMapping(value = "floor-list", method = RequestMethod.GET)
	private String doFloorView(Model m)
	{
		return "floor-list";
	}

	@RequestMapping(value = "building-detail", method = RequestMethod.GET)
	private String doDetailBuildingView(Model m)
	{
		return "redirect:/management/building/building-list.html";
	}

	@RequestMapping(value = "building-detail", params = "id", method = RequestMethod.GET)
	private String doDetailBuildingView(@RequestParam(value = "id") String id,
			Model m, HttpSession session)
	{
		try
		{
			Building building = buildingService.getById(Short.parseShort(id));
			m.addAttribute("building", building);
			return "building-detail";
		} catch (Exception e)
		{
			session.setAttribute("msg", "Building does not exit");
			return "redirect:/management/building/building-list.html";
		}
	}
	
	@RequestMapping(value = "getEmployeeInBuilding", params = "buildingId", method = RequestMethod.GET)
	@ResponseBody
	public DatatableResponse<EmployeeDto> getEmployeeInBuilding(@RequestParam(value="buildingId")String id) {
		DatatableResponse<EmployeeDto> response = new DatatableResponse<>();
		Building building = buildingService.getById(Short.parseShort(id));
		List<Employee> listEmployee = employeeService.getEmployeeByBuilding(building);
		List<EmployeeDto> listEmployeeDto = EmployeeDto.map(listEmployee);
		response.setAaData(listEmployeeDto);
		return response;
	}
	
	@RequestMapping(value = "getFloorInBuilding", params = "buildingId", method = RequestMethod.GET)
	@ResponseBody
	public DatatableResponse<FloorDto> getFloorInBuilding(@RequestParam(value="buildingId")String id) {
		DatatableResponse<FloorDto> response = new DatatableResponse<>();
		Building building = buildingService.getById(Short.parseShort(id));
		List<Floor> floors = floorService.getFloorByBuilding(building);
		List<FloorDto> listFloorDto = FloorDto.map(floors);
		response.setAaData(listFloorDto);
		return response;
	}

	// @RequestMapping(value="getAllBuilding", method=RequestMethod.GET)
	// @ResponseBody
	// private List<Building> getAllBuilding() {
	// List<Building> listBuilding = buildingService.getAll();
	// return listBuilding;
	// }

	@RequestMapping(value = "getBuildingById", params="id", method = RequestMethod.GET)
	@ResponseBody
	private StatusResponse<Building> getBuildingById(@RequestParam(value = "id") Short id)
	{
		Building building = buildingService.getById(id);
		StatusResponse<Building> statusResponse = new StatusResponse<>(true);
		statusResponse.setObject(building);
		return statusResponse;
	}

	// Jqgrid
	// @RequestMapping(value="getAllBuildingByPage", method=RequestMethod.GET)
	// @ResponseBody
	// public JqgridResponse<BuildingDto> getAllBuilding(Paging paging) {
	// Pageable pageRequest = new PageRequest(paging.getPage() - 1,
	// paging.getRows());
	//
	// if (paging.get_search()) {
	// return getFilteredRecords(paging.getFilters(), pageRequest);
	// }
	// Page<Building> building = buildingService.findAll(pageRequest);
	// List<BuildingDto> listBuilding = BuildingDto.map(building);
	// response.setRows(listBuilding);
	// response.setPage(Integer.valueOf(buildings.getNumber() + 1).toString());
	// response.setTotal(Integer.valueOf(buildings.getTotalPages()).toString());
	// response.setRecords(Long.valueOf(buildings.getTotalElements()).toString());
	// return response;
	// }

	// datatable
	@RequestMapping(value = "getAllBuilding", method = RequestMethod.GET)
	@ResponseBody
	private DatatableResponse<BuildingDto> getAllBuilding(Model m)
	{
		List<Building> buildings = buildingService.getAll();
		List<BuildingDto> aaData = BuildingDto.map(buildings);
		DatatableResponse<BuildingDto> dataResponse = new DatatableResponse<>();
		dataResponse.setAaData(aaData);
		return dataResponse;
	}

	@RequestMapping(value = "addBuilding", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Building> doAdd(Building building, BindingResult rs)
	{
		if ( !rs.hasErrors() )
		{
			District district = districtService.getById(building.getAddress()
					.getDistrict().getId());
			building.getAddress().setDistrict(null);
			buildingService.add(building);
			building.getAddress().setDistrict(district);
			buildingService.update(building);
			return new StatusResponse<Building>(true);
		} else
		{
			StatusResponse<Building> statusResponse = new StatusResponse<>();
			statusResponse.setSuccess(false);
			for ( ObjectError err : rs.getAllErrors() )
			{
				statusResponse.addMessage(err.getDefaultMessage());
			}
			return statusResponse;
		}
	}

	@RequestMapping(value = "updateBuilding", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Building> doUpdate(Building building, BindingResult rs)
	{
		if ( !rs.hasErrors() )
		{
			District district = districtService.getById(building.getAddress()
					.getDistrict().getId());
			building.getAddress().setDistrict(district);
			buildingService.update(building);
			return new StatusResponse<Building>(true);
		} else
		{
			StatusResponse<Building> statusResponse = new StatusResponse<>();
			statusResponse.setSuccess(false);
			for ( ObjectError err : rs.getAllErrors() )
			{
				statusResponse.addMessage(err.getDefaultMessage());
			}
			return statusResponse;
		}
	}

	// @RequestParam(value="id")
	@RequestMapping(value = "deleteBuilding", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Building> doDelete(Building building)
	{
		buildingService.delete(building);
		return new StatusResponse<Building>(true);
	}

}
