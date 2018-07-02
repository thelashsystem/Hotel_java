package com.apartment.management.dao.imp.status;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.status.StatusDaoInf;
import com.apartment.management.model.status.Status;

@Component
@Repository
public class StatusDao implements StatusDaoInf
{

	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(Status status)
	{
		session().persist(status);
	}

	@Override
	public void update(Status status)
	{
		session().update(status);
	}

	@Override
	public void delete(Status status)
	{
		session().delete(status);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Status> getAll()
	{
		return session().createCriteria(Status.class).list();
	}

	@Override
	public Status getById(Byte id)
	{
		Criteria crit = session().createCriteria(Status.class);
		crit.add(Restrictions.idEq(id));
		return (Status) crit.uniqueResult();
	}
}
