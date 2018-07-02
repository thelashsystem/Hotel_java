package com.apartment.management.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apartment.management.model.street.City;
import com.apartment.management.model.street.District;
import com.apartment.management.response.DependentSelectResponse;
import com.apartment.management.response.StatusResponse;
import com.apartment.management.service.interfaces.street.CityService;
import com.apartment.management.service.interfaces.street.DistrictService;

@Controller
@RequestMapping(value = "address")
public class AddressController
{
	@Autowired
	private DistrictService districtService;
	@Autowired
	private CityService cityService;

	@RequestMapping(value = "address-list", method = RequestMethod.GET)
	public String doView()
	{
		return "address-list";
	}

	@RequestMapping(value = "getAllCity", method = RequestMethod.GET)
	@ResponseBody
	public List<City> getAllCity()
	{
		List<City> listCity = cityService.getAll();
		return listCity;
	}

	@RequestMapping(value = "getAllDistrict", method = RequestMethod.GET)
	@ResponseBody
	public List<District> getAllDistrict()
	{
		List<District> listCity = districtService.getAll();
		return listCity;
	}

	@RequestMapping(value = "addDistrict", method = RequestMethod.POST)
	@ResponseBody
	public StatusResponse<District> addDistrict(District district, BindingResult rs)
	{
		if ( !rs.hasErrors() )
		{
			City city = cityService.getById(district.getCity().getId());
			district.setCity(null);
			districtService.add(district);
			district.setCity(city);
			districtService.update(district);
			return new StatusResponse<District>(true);
		} else
		{
			StatusResponse<District>  statusResponse = new StatusResponse<>(false);
			for ( ObjectError err : rs.getAllErrors() )
			{
				statusResponse.addMessage(err.getDefaultMessage());
			}
			return statusResponse;
		}
	}

	@RequestMapping(value = "addCity", method = RequestMethod.POST)
	@ResponseBody
	public StatusResponse<City>  addCity(City city, BindingResult rs)
	{
		if ( !rs.hasErrors() )
		{
			cityService.add(city);
			return new StatusResponse<>(true);
		} else
		{
			StatusResponse<City> statusResponse = new StatusResponse<>(false);
			for ( ObjectError err : rs.getAllErrors() )
			{
				statusResponse.addMessage(err.getDefaultMessage());
			}
			return statusResponse;
		}
	}

	@RequestMapping(value = "updateCity", method = RequestMethod.POST)
	public StatusResponse<City> updateCity(District district, BindingResult rs)
	{
		if ( !rs.hasErrors() )
		{
			districtService.update(district);
			return new StatusResponse<>(true);
		} else
		{
			StatusResponse<City> statusResponse = new StatusResponse<>(false);
			for ( ObjectError err : rs.getAllErrors() )
			{
				statusResponse.addMessage(err.getDefaultMessage());
			}
			return statusResponse;
		}
	}

	@RequestMapping(value = "updateDistrict", method = RequestMethod.POST)
	public StatusResponse<City> updateDistrict(City city, BindingResult rs)
	{
		if ( !rs.hasErrors() )
		{
			cityService.update(city);
			return new StatusResponse<>(true);
		} else
		{
			StatusResponse<City> statusResponse = new StatusResponse<>(false);
			for ( ObjectError err : rs.getAllErrors() )
			{
				statusResponse.addMessage(err.getDefaultMessage());
			}
			return statusResponse;
		}
	}

	@RequestMapping(value = "getDistrictByCity", method = RequestMethod.POST)
	@ResponseBody
	public DependentSelectResponse<District> doGetDistrictByCity(
			@RequestParam(value = "depdrop_parents[0]") Short id)
	{
		City city = cityService.getById(id);
		List<District> listDistrict = districtService.getDistrictByCity(city);
		DependentSelectResponse<District> response = new DependentSelectResponse<>();
		response.setOutput(listDistrict);
		if ( listDistrict.size() != 0 )
		{
			response.setSelected(listDistrict.get(0).getId().toString());
		}
		return response;
	}
}
