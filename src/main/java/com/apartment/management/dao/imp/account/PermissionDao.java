package com.apartment.management.dao.imp.account;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.account.PermissionDaoInf;
import com.apartment.management.model.account.Permission;

@Component
@Repository
public class PermissionDao implements PermissionDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(Permission permission)
	{
		session().persist(permission);
	}

	@Override
	public void update(Permission permission)
	{
		session().update(permission);
	}

	@Override
	public void delete(Permission permission)
	{
		session().delete(permission);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Permission> getAll()
	{
		return session().createCriteria(Permission.class).list();
	}

	@Override
	public Permission getById(Short id)
	{
		Criteria crit = session().createCriteria(Permission.class);
		crit.add(Restrictions.idEq(id));
		return (Permission) crit.uniqueResult();
	}
}
