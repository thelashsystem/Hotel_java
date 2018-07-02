package com.apartment.management.controller.view;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apartment.management.model.account.CustomerAccount;
import com.apartment.management.model.building.Apartment;
import com.apartment.management.model.business.BookingApartment;
import com.apartment.management.response.BookingRequest;
import com.apartment.management.service.interfaces.account.CustomerAccountService;
import com.apartment.management.service.interfaces.building.ApartmentService;
import com.apartment.management.service.interfaces.business.BookingApartmentService;

@Controller
public class BookingController
{
	@Autowired
	private ApartmentService apartmentService;

	@Autowired
	private BookingApartmentService bookingApartmentService;

	@Autowired
	private CustomerAccountService customerAccountService;

	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		PropertyEditor dateEditor = new PropertyEditorSupport()
		{
			@Override
			public void setAsText(String text) throws IllegalArgumentException
			{
				try
				{
					if ( !text.isEmpty() )
					{
						String pattern = "MM/dd/yyyy";
						SimpleDateFormat dateFormat = new SimpleDateFormat(
								pattern);
						dateFormat.setLenient(false);
						String str = dateFormat.format(dateFormat.parse(text));
						if ( str.equals(text)
								&& str.length() == pattern.length() )
						{
							Date date = new Date(dateFormat.parse(text)
									.getTime());
							setValue(date);
						} else
						{
							throw new Exception();
						}

					} else
					{
						setValue(null);
					}

				} catch (Exception e)
				{
					setValue(text);
				}
			}

			@Override
			public String getAsText()
			{
				return getValue() != null ? new SimpleDateFormat("MM/dd/yyyy")
						.format((Date) getValue()) : "";
			}
		};
		binder.registerCustomEditor(Date.class, "checkIn", dateEditor);
		binder.registerCustomEditor(Date.class, "checkOut", dateEditor);
		binder.registerCustomEditor(Date.class, "customer.profile.birthday", dateEditor);
	}

	@RequestMapping(value = "/booking-apartment", method = RequestMethod.GET)
	public String doView(HttpSession session, Model m)
	{
		return "booking-apartment";
	}
	
	@RequestMapping(value = "/history-booking", method = RequestMethod.GET)
	public String doHistoryBookingView(HttpSession session, Model m)
	{
		return "history-booking";
	}

	@RequestMapping(value = "/booking-apartment", method = RequestMethod.POST)
	public String doView(BookingRequest bookingRequest, BindingResult rs,
			HttpSession session, Model m)
	{
		if ( session.getAttribute("user") != null )
		{
			CustomerAccount customerAccount = (CustomerAccount) session
					.getAttribute("user");
			BookingApartment booking = new BookingApartment();
			Apartment apartment = apartmentService.getById(bookingRequest
					.getApartmentId());
			
			booking.setCustomer(customerAccount.getCustomer());
			booking.setBookingDate(new Timestamp(new java.util.Date().getTime()));
			booking.setCheckin(bookingRequest.getCheckIn());
			booking.setCheckout(bookingRequest.getCheckOut());
			booking = bookingApartmentService.addBooking(booking);
			booking.setApartment(apartment);
			bookingApartmentService.update(booking);
			m.addAttribute("booking",
					"Booking successfully! We will contact you soon as posible");
			return "booking-apartment";
		} else
		{
			m.addAttribute("bookingRequest", bookingRequest);
			return "booking-apartment";
		}

	}

	@RequestMapping(value = "/booking-apartment-create-account", method = RequestMethod.POST)
	public String doView(BookingRequest bookingRequest,
			CustomerAccount customerAccount, BindingResult rs, HttpSession session, Model m)
	{ 
		BookingApartment booking = new BookingApartment();
		customerAccountService.add(customerAccount);
		customerAccount = customerAccountService.getAccount(customerAccount);
		Apartment apartment = apartmentService.getById(bookingRequest
				.getApartmentId());
		booking.setApartment(apartment);
		booking.setBookingDate(new Timestamp(new java.util.Date().getTime()));
		booking.setCheckin(bookingRequest.getCheckIn());
		booking.setCheckout(bookingRequest.getCheckOut());
		booking = bookingApartmentService.addBooking(booking);
		booking.setCustomer(customerAccount.getCustomer());
		bookingApartmentService.update(booking);
		m.addAttribute("booking",
				"Booking successfully! We will contact you soon as posible");
		return "booking-apartment";
	}
}
