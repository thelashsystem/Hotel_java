package com.apartment.management.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apartment.management.model.business.BookingApartment;
import com.apartment.management.response.DatatableResponse;
import com.apartment.management.response.StatusResponse;
import com.apartment.management.response.dto.BookingDto;
import com.apartment.management.service.interfaces.business.BookingApartmentService;

@Controller
@RequestMapping(value = "booking")
public class BookingApartmentController
{
	@Autowired
	private BookingApartmentService bookingApartmentService;

	@RequestMapping(value = "booking-apartment", method = RequestMethod.GET)
	public String doView(Model m)
	{
		return "booking-apartment";
	}

	@RequestMapping(value = "booking-detail", method = RequestMethod.GET)
	private String doDetailBookingView()
	{
		return "booking-detail";
	}
	
	@RequestMapping(value = "overview-apartment", method = RequestMethod.GET)
	private String doOverViewApartmentView()
	{
		return "overview-apartment";
	}

	@RequestMapping(value = "getAllBooking", method = RequestMethod.GET)
	@ResponseBody
	private DatatableResponse<BookingDto> getAllBooking()
	{
		DatatableResponse<BookingDto> response = new DatatableResponse<>();
		List<BookingApartment> listBookingApartment = bookingApartmentService
				.getAll();
		List<BookingDto> listBookingDto = BookingDto.map(listBookingApartment);
		response.setAaData(listBookingDto);
		return response;
	}

	@RequestMapping(value = "addBooking", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<BookingApartment> doAdd()
	{
		return new StatusResponse<BookingApartment>();
	}

	@RequestMapping(value = "updateBooking", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<BookingApartment> doUpdate()
	{
		return new StatusResponse<BookingApartment>();
	}

	@RequestMapping(value = "deleteBooking", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<BookingApartment> doDelete()
	{
		return new StatusResponse<BookingApartment>();
	}
}
