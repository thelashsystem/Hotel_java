package com.apartment.management.dao.imp.building;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.building.BuildingDaoInf;
import com.apartment.management.model.building.Building;

@Component
@Repository
public class BuildingDao implements BuildingDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(Building apartment)
	{
		session().persist(apartment);
	}

	@Override
	public void update(Building apartment)
	{
		session().update(apartment);
	}

	@Override
	public void delete(Building apartment)
	{
		session().delete(apartment);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Building> getAll()
	{
		return session().createCriteria(Building.class).list();
	}

	@Override
	public Building getById(Short id)
	{
		Criteria crit = session().createCriteria(Building.class);
		crit.add(Restrictions.idEq(id));
		return (Building) crit.uniqueResult();
	}

}
