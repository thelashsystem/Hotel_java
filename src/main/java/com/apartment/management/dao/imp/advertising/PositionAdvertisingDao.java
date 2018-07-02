package com.apartment.management.dao.imp.advertising;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.advertising.PositionAdvertisingDaoInf;
import com.apartment.management.model.advertising.PositionAdvertising;

@Component
@Repository
public class PositionAdvertisingDao implements PositionAdvertisingDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(PositionAdvertising positionAdvertising)
	{
		session().persist(positionAdvertising);
	}

	@Override
	public void update(PositionAdvertising positionAdvertising)
	{
		session().update(positionAdvertising);
	}

	@Override
	public void delete(PositionAdvertising positionAdvertising)
	{
		session().delete(positionAdvertising);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PositionAdvertising> getAll()
	{
		return session().createCriteria(PositionAdvertising.class).list();
	}

	@Override
	public PositionAdvertising getById(Short id)
	{
		Criteria crit = session().createCriteria(PositionAdvertising.class);
		crit.add(Restrictions.idEq(id));
		return (PositionAdvertising) crit.uniqueResult();
	}
}
