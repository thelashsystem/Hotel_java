package com.apartment.management.dao.imp.building;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.building.IconDaoInf;
import com.apartment.management.model.building.Icon;

@Component
@Repository
public class IconDao implements IconDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(Icon icon)
	{
		session().persist(icon);
	}

	@Override
	public void update(Icon icon)
	{
		session().update(icon);
	}

	@Override
	public void delete(Icon icon)
	{
		session().delete(icon);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Icon> getAll()
	{
		return session().createCriteria(Icon.class).list();
	}

	@Override
	public Icon getById(Short id)
	{
		Criteria crit = session().createCriteria(Icon.class);
		crit.add(Restrictions.idEq(id));
		return (Icon) crit.uniqueResult();
	}
}
