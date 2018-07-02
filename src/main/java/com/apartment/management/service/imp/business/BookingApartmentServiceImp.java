package com.apartment.management.service.imp.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.interfaces.business.BookingApartmentDaoInf;
import com.apartment.management.model.business.BookingApartment;
import com.apartment.management.service.interfaces.business.BookingApartmentService;

@Component
@Service
@Transactional
public class BookingApartmentServiceImp implements BookingApartmentService
{
	@Autowired
	private BookingApartmentDaoInf bookingApartmentDao;

	@Override
	public void add(BookingApartment bookingApartment)
	{
		bookingApartmentDao.add(bookingApartment);
	}

	@Override
	public void update(BookingApartment bookingApartment)
	{
		bookingApartmentDao.update(bookingApartment);
	}

	@Override
	public void delete(BookingApartment bookingApartment)
	{
		bookingApartmentDao.delete(bookingApartment);
	}

	@Override
	public List<BookingApartment> getAll()
	{
		return bookingApartmentDao.getAll();
	}

	@Override
	public BookingApartment getById(Long id)
	{
		return bookingApartmentDao.getById(id);
	}

	@Override
	public BookingApartment addBooking(BookingApartment bookingApartment)
	{
		return bookingApartmentDao.addBooking(bookingApartment);
	}

}
