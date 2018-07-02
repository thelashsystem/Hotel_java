package com.apartment.management.dao.imp.image;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.image.GalleryDaoInf;
import com.apartment.management.model.image.Gallery;

@Component
@Repository
public class GalleryDao<T extends Gallery> implements GalleryDaoInf<T>
{
	@Autowired
	private SessionFactory sessionFactory;

	private Class<T> returnedClass;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(T gallery)
	{
		session().persist(gallery);
	}

	@Override
	public void update(T gallery)
	{
		session().update(gallery);
	}

	@Override
	public void delete(T gallery)
	{
		session().delete(gallery);
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
