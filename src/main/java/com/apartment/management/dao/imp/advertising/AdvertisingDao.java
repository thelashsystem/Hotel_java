package com.apartment.management.dao.imp.advertising;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.advertising.AdvertisingDaoInf;
import com.apartment.management.model.advertising.Advertising;

@Component
@Repository
public class AdvertisingDao implements AdvertisingDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(Advertising advertising)
	{
		session().persist(advertising);
	}

	@Override
	public void update(Advertising advertising)
	{
		session().update(advertising);
	}

	@Override
	public void delete(Advertising advertising)
	{
		session().delete(advertising);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Advertising> getAll()
	{
		return session().createCriteria(Advertising.class).list();
	}

	@Override
	public Advertising getById(Integer id)
	{
		Criteria crit = session().createCriteria(Advertising.class);
		crit.add(Restrictions.idEq(id));
		return (Advertising) crit.uniqueResult();
	}
}
