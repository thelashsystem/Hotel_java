package com.apartment.management.dao.imp.street;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.street.WardDaoInf;
import com.apartment.management.model.street.Ward;

@Component
@Repository
public class WardDao implements WardDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(Ward ward)
	{
		session().persist(ward);
	}

	@Override
	public void update(Ward ward)
	{
		session().update(ward);
	}

	@Override
	public void delete(Ward ward)
	{
		session().delete(ward);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ward> getAll()
	{
		return session().createCriteria(Ward.class).list();
	}

	@Override
	public Ward getById(Short id)
	{
		Criteria crit = session().createCriteria(Ward.class);
		crit.add(Restrictions.idEq(id));
		return (Ward) crit.uniqueResult();
	}
}
