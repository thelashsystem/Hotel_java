package com.apartment.management.service.interfaces.business;

import com.apartment.management.model.business.BookingApartment;
import com.apartment.management.service.interfaces.GeneralService;

public interface BookingApartmentService extends
		GeneralService<BookingApartment, Long>
{
	public BookingApartment addBooking(BookingApartment bookingApartment);
}
