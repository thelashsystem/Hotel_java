package com.apartment.management.dao.imp.business;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.business.BillingDetailDaoInf;
import com.apartment.management.model.business.BillingDetail;

//@Component
@Repository
public abstract class BillingDetailDao<T extends BillingDetail> implements
		BillingDetailDaoInf<T>
{

	@Autowired
	private SessionFactory sessionFactory;

	protected Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public BillingDetailDao()
	{
		persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(T billDetail)
	{
		session().persist(billDetail);
	}

	@Override
	public void update(T billDetail)
	{
		session().update(billDetail);
	}

	@Override
	public void delete(T billDetail)
	{
		session().delete(billDetail);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> getAll()
	{
		return session().createCriteria(persistentClass).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public T getById(Long id)
	{
		Criteria crit = session().createCriteria(persistentClass);
		crit.add(Restrictions.idEq(id));
		return (T) crit.uniqueResult();
	}
}
