package com.apartment.management.dao.imp.business;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.business.BookingApartmentDaoInf;
import com.apartment.management.model.business.BookingApartment;

@Component
@Repository
public class BookingApartmentDao implements BookingApartmentDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(BookingApartment bookingApartment)
	{
		session().persist(bookingApartment);
	}

	@Override
	public void update(BookingApartment bookingApartment)
	{
		session().update(bookingApartment);
	}

	@Override
	public void delete(BookingApartment bookingApartment)
	{
		session().delete(bookingApartment);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookingApartment> getAll()
	{
		return session().createCriteria(BookingApartment.class).list();
	}

	@Override
	public BookingApartment getById(Long id)
	{
		Criteria crit = session().createCriteria(BookingApartment.class);
		crit.add(Restrictions.idEq(id));
		return (BookingApartment) crit.uniqueResult();
	}

	@Override
	public BookingApartment addBooking(BookingApartment bookingApartment)
	{
		Long id = (Long) session().save(bookingApartment);
		BookingApartment booking = getById(id);
		return booking;
	}
}
