package com.apartment.management.dao.imp.contract;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.contract.ContractDaoInf;
import com.apartment.management.model.contract.Contract;

//@Component
@Repository
public abstract class ContractDao<T extends Contract> implements
		ContractDaoInf<T>
{
	@Autowired
	private SessionFactory sessionFactory;

	protected Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public ContractDao()
	{
		persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	protected Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(T contract)
	{
		session().persist(contract);
	}

	@Override
	public void update(T contract)
	{
		session().update(contract);
	}

	@Override
	public void delete(T contract)
	{
		session().delete(contract);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> getAll()
	{
		return session().createCriteria(persistentClass).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public T getById(Integer id)
	{
		Criteria crit = session().createCriteria(persistentClass);
		crit.add(Restrictions.idEq(id));
		return (T) crit.uniqueResult();
	}
}
