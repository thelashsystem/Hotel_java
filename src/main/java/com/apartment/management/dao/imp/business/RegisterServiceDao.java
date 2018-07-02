package com.apartment.management.dao.imp.business;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.business.RegisterServiceDaoInf;
import com.apartment.management.model.business.RegisterService;

@Component
@Repository
public class RegisterServiceDao implements RegisterServiceDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(RegisterService obj)
	{
		session().persist(obj);
	}

	@Override
	public void update(RegisterService obj)
	{
		session().update(obj);
	}

	@Override
	public void delete(RegisterService obj)
	{
		session().delete(obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RegisterService> getAll()
	{
		return session().createCriteria(RegisterService.class).list();
	}

	@Override
	public RegisterService getById(Integer id)
	{
		Criteria crit = session().createCriteria(RegisterService.class);
		return (RegisterService) crit.add(Restrictions.idEq(id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RegisterService> getUnexpiredRegisteredService()
	{
		Criteria crit = session().createCriteria(RegisterService.class);
		crit.add(Restrictions.isNull("cancelService"));
		return crit.list();
	}

}
