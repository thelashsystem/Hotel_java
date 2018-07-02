package com.apartment.management.dao.imp.parkingLot;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.parkingLot.TransportDaoInf;
import com.apartment.management.model.parkingLot.Transport;

@Component
@Repository
public class TransportDao<T extends Transport> implements TransportDaoInf<T>
{
	@Autowired
	private SessionFactory sessionFactory;

	private Class<T> returnedClass;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(T transport)
	{
		session().persist(transport);
	}

	@Override
	public void update(T transport)
	{
		session().update(transport);
	}

	@Override
	public void delete(T transport)
	{
		session().delete(transport);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll()
	{
		return session().createCriteria(returnedClass).list();
	}

	@SuppressWarnings("unchecked")
	public T getById(Integer id)
	{
		Criteria crit = session().createCriteria(returnedClass);
		crit.add(Restrictions.idEq(id));
		return (T) crit.uniqueResult();
	}
}
