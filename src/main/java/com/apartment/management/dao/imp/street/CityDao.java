package com.apartment.management.dao.imp.street;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.street.CityDaoInf;
import com.apartment.management.model.street.City;

@Component
@Repository
public class CityDao implements CityDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(City city)
	{
		session().persist(city);
	}

	@Override
	public void update(City city)
	{
		session().update(city);
	}

	@Override
	public void delete(City city)
	{
		session().delete(city);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<City> getAll()
	{
		return session().createCriteria(City.class).list();
	}

	@Override
	public City getById(Short id)
	{
		Criteria crit = session().createCriteria(City.class);
		crit.add(Restrictions.idEq(id));
		return (City) crit.uniqueResult();
	}

}
