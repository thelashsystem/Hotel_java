package com.apartment.management.dao.imp.person;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.person.PersonDaoInf;
import com.apartment.management.model.person.Person;

@Repository
public abstract class PersonDao<T extends Person> implements PersonDaoInf<T>
{
	@Autowired
	private SessionFactory sessionFactory;

	private Class<T> returnedClass;

	public PersonDao(Class<T> clazz)
	{
		returnedClass = clazz;
	}

	protected Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(T person)
	{
		session().persist(person);
	}

	@Override
	public void update(T person)
	{
		session().update(person);
	}

	@Override
	public void delete(T person)
	{
		session().delete(person);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> getAll()
	{
		Criteria crit = session().createCriteria(returnedClass);
		return crit.list();
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
