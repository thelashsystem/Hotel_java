package com.apartment.management.dao.imp.account;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.account.AccountDaoInf;
import com.apartment.management.model.account.Account;

@Repository
public abstract class AccountDao<T extends Account> implements
		AccountDaoInf<T, Integer>
{
	@Autowired
	private SessionFactory sessionFactory;

	protected Class<T> persistentClass;

	protected Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public AccountDao()
	{
		persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void add(T account)
	{
		session().persist(account);
	}

	@Override
	public void update(T account)
	{
		session().update(account);
	}

	@Override
	public void delete(T account)
	{
		session().delete(account);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getAccount(T account)
	{
		Criteria crit = session().createCriteria(account.getClass());
		crit.add(Restrictions.eq("email", account.getEmail()));
		crit.add(Restrictions.eq("password", account.getPassword()));
		return (T) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll()
	{
		return session().createCriteria(persistentClass).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(Integer id)
	{
		Criteria crit = session().createCriteria(persistentClass);
		crit.add(Restrictions.idEq(id));
		return (T) crit.uniqueResult();

	}

}
