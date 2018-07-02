package com.apartment.management.dao.imp.street;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.street.DistrictDaoInf;
import com.apartment.management.model.street.City;
import com.apartment.management.model.street.District;

@Component
@Repository
public class DistrictDao implements DistrictDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(District district)
	{
		session().persist(district);
	}

	@Override
	public void update(District district)
	{
		session().update(district);
	}

	@Override
	public void delete(District district)
	{
		session().delete(district);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<District> getAll()
	{
		return session().createCriteria(District.class).list();
	}

	@Override
	public District getById(Short id)
	{
		Criteria crit = session().createCriteria(District.class);
		crit.add(Restrictions.idEq(id));
		return (District) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<District> getDistrictByCity(City city)
	{
		Criteria crit = session().createCriteria(District.class);
		crit.add(Restrictions.eq("city", city));
		return crit.list();
	}

}
