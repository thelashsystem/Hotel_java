package com.apartment.management.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apartment.management.model.asset.Equipment;
import com.apartment.management.model.parkingLot.Transport;
import com.apartment.management.response.DatatableResponse;
import com.apartment.management.response.StatusResponse;
import com.apartment.management.response.dto.CarDto;
import com.apartment.management.service.interfaces.parkingLot.TransportService;

@Controller
@RequestMapping("car")
public class CarController
{
	@Autowired
	private TransportService<Transport> transportService;

	@RequestMapping(value = "car-list", method = RequestMethod.GET)
	public String doView()
	{
		return "car-list";
	}

	@RequestMapping(value = "car-detail", method = RequestMethod.GET)
	public String doDetailView()
	{
		return "car-detail";
	}

	@RequestMapping(value = "getAllCar", method = RequestMethod.GET)
	@ResponseBody
	private DatatableResponse<CarDto> getAllCar()
	{
		DatatableResponse<CarDto> response = new DatatableResponse<>();
		List<Transport> listTransport = transportService.getAll();
		List<CarDto> listCarDto = CarDto.map(listTransport);
		response.setAaData(listCarDto);
		return response;
	}

	@RequestMapping(value = "addCar", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Transport> doAdd()
	{
		return new StatusResponse<Transport>();
	}

	@RequestMapping(value = "updateCar", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Transport> doUpdate()
	{
		return new StatusResponse<Transport>();
	}

	@RequestMapping(value = "deleteCar", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Transport> doDelete()
	{
		return new StatusResponse<Transport>();
	}
}
