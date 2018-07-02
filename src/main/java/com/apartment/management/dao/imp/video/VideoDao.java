package com.apartment.management.dao.imp.video;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.video.VideoDaoInf;
import com.apartment.management.model.video.Video;

@Component
@Repository
public class VideoDao<T extends Video> implements VideoDaoInf<T>
{
	@Autowired
	private SessionFactory sessionFactory;

	private Class<T> returnedClass;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(T video)
	{
		session().persist(video);
	}

	@Override
	public void update(T video)
	{
		session().update(video);
	}

	@Override
	public void delete(T video)
	{
		session().delete(video);
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
