package com.apartment.management.dao.imp.provider;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.provider.ProviderDaoInf;
import com.apartment.management.model.provider.Provider;

@Component
@Repository
public class ProviderDao<T extends Provider> implements ProviderDaoInf<T>
{
	@Autowired
	private SessionFactory sessionFactory;

	private Class<T> returnedClass;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(T provider)
	{
		session().persist(provider);
	}

	@Override
	public void update(T provider)
	{
		session().update(provider);
	}

	@Override
	public void delete(T provider)
	{
		session().delete(provider);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> getAll()
	{
		return session().createCriteria(returnedClass).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public T getById(Integer id)
	{
		Criteria crit = session().createCriteria(returnedClass);
		crit.add(Restrictions.idEq(id));
		return (T) crit.uniqueResult();
	}

}
