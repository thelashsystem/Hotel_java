package com.apartment.management.dao.interfaces.business;

import com.apartment.management.dao.interfaces.GeneralDao;
import com.apartment.management.model.business.BookingApartment;

public interface BookingApartmentDaoInf extends
		GeneralDao<BookingApartment, Long>
{
	public BookingApartment addBooking(BookingApartment bookingApartment);
}
