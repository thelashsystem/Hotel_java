package com.apartment.management.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apartment.management.model.parkingLot.CheckInOutCar;
import com.apartment.management.model.parkingLot.ParkingLot;
import com.apartment.management.model.parkingLot.Transport;
import com.apartment.management.response.DatatableResponse;
import com.apartment.management.response.StatusResponse;
import com.apartment.management.response.dto.CheckInOutCarDto;
import com.apartment.management.response.dto.ParkingLotDto;
import com.apartment.management.service.interfaces.parkingLot.CheckInOutCarService;
import com.apartment.management.service.interfaces.parkingLot.ParkingLotService;

@Controller
@RequestMapping("parking-lot")
public class ParkingLotController
{
	@Autowired
	private ParkingLotService parkingLotService;

	@Autowired
	private CheckInOutCarService checkInOutCarService;

	@RequestMapping(value = "parking-lot-list", method = RequestMethod.GET)
	private String doParkingLotView()
	{
		return "parking-lot-list";
	}

	@RequestMapping(value = "car-list", method = RequestMethod.GET)
	private String doCarView()
	{
		return "parking-lot-list";
	}

	@RequestMapping(value = "check-in-out-car", method = RequestMethod.GET)
	private String doCheckInOutCarView()
	{
		return "check-in-out-car";
	}

	@RequestMapping(value = "getAllCheckInOutCar", method = RequestMethod.GET)
	@ResponseBody
	public DatatableResponse<CheckInOutCarDto> doCheckInOutView()
	{
		DatatableResponse<CheckInOutCarDto> response = new DatatableResponse<>();
		List<CheckInOutCar> listCheckInOutCar = checkInOutCarService.getAll();
		List<CheckInOutCarDto> listCheckInOutCarDto = CheckInOutCarDto
				.map(listCheckInOutCar);
		response.setAaData(listCheckInOutCarDto);
		return response;
	}

	@RequestMapping(value = "getAllParkingLot", method = RequestMethod.GET)
	@ResponseBody
	private DatatableResponse<ParkingLotDto> getAllRoomType()
	{
		DatatableResponse<ParkingLotDto> response = new DatatableResponse<>();
		List<ParkingLot> listParkingLot = parkingLotService.getAll();
		List<ParkingLotDto> parkingLotDtos = ParkingLotDto.map(listParkingLot);
		response.setAaData(parkingLotDtos);
		return response;
	}

	@RequestMapping(value = "addParkingLot", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<ParkingLot> doAdd()
	{
		return new StatusResponse<ParkingLot>();
	}

	@RequestMapping(value = "updateParkingLot", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<ParkingLot> doUpdate()
	{
		return new StatusResponse<ParkingLot>();
	}

	@RequestMapping(value = "deleteParkingLot", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<ParkingLot> doDelete()
	{
		return new StatusResponse<ParkingLot>();
	}
}
