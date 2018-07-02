package com.apartment.management.dao.imp.building;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.building.ServiceDaoInf;
import com.apartment.management.model.building.Service;

@Component
@Repository
public class ServiceDao implements ServiceDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(Service service)
	{
		session().persist(service);
	}

	@Override
	public void update(Service service)
	{
		session().update(service);
	}

	@Override
	public void delete(Service service)
	{
		session().delete(service);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Service> getAll()
	{
		return session().createCriteria(Service.class).list();
	}

	@Override
	public Service getById(Short id)
	{
		Criteria crit = session().createCriteria(Service.class);
		crit.add(Restrictions.idEq(id));
		return (Service) crit.uniqueResult();
	}

}
