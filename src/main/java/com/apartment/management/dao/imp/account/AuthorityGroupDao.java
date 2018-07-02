package com.apartment.management.dao.imp.account;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.account.AuthorityGroupDaoInf;
import com.apartment.management.model.account.AuthorityGroup;

@Component
@Repository
public class AuthorityGroupDao implements AuthorityGroupDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(AuthorityGroup authorityGroup)
	{
		session().persist(authorityGroup);
	}

	@Override
	public void update(AuthorityGroup authorityGroup)
	{
		session().update(authorityGroup);
	}

	@Override
	public void delete(AuthorityGroup authorityGroup)
	{
		session().delete(authorityGroup);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AuthorityGroup> getAll()
	{
		return session().createCriteria(AuthorityGroup.class).list();
	}

	@Override
	public AuthorityGroup getById(Short id)
	{
		Criteria crit = session().createCriteria(AuthorityGroup.class);
		crit.add(Restrictions.idEq(id));
		return (AuthorityGroup) crit.uniqueResult();
	}
}
