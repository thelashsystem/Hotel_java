package com.apartment.management.dao.imp.business;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.business.GuestDaoInf;
import com.apartment.management.model.business.Guest;

@Component
@Repository
public class GuestDao implements GuestDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(Guest guest)
	{
		session().persist(guest);
	}

	@Override
	public void update(Guest guest)
	{
		session().update(guest);
	}

	@Override
	public void delete(Guest guest)
	{
		session().delete(guest);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Guest> getAll()
	{
		return session().createCriteria(Guest.class).list();
	}

	@Override
	public Guest getById(Long id)
	{
		Criteria crit = session().createCriteria(Guest.class);
		crit.add(Restrictions.idEq(id));
		return (Guest) crit.uniqueResult();
	}
}
