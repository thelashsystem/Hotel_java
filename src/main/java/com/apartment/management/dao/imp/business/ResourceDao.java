package com.apartment.management.dao.imp.business;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.business.ResourceDaoInf;
import com.apartment.management.model.business.Resource;

@Component
@Repository
public class ResourceDao implements ResourceDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(Resource resource)
	{
		session().persist(resource);
	}

	@Override
	public void update(Resource resource)
	{
		session().update(resource);
	}

	@Override
	public void delete(Resource resource)
	{
		session().delete(resource);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> getAll()
	{
		return session().createCriteria(Resource.class).list();
	}

	@Override
	public Resource getById(Short id)
	{
		Criteria crit = session().createCriteria(Resource.class);
		crit.add(Restrictions.idEq(id));
		return (Resource) crit.uniqueResult();
	}
}
