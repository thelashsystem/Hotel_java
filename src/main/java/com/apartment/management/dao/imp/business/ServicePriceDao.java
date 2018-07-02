package com.apartment.management.dao.imp.business;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.business.ServicePriceDaoInf;
import com.apartment.management.model.building.Service;
import com.apartment.management.model.business.ServicePrice;

@Component
@Repository
public class ServicePriceDao implements ServicePriceDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(ServicePrice servicePrice)
	{
		session().persist(servicePrice);
	}

	@Override
	public void update(ServicePrice servicePrice)
	{
		session().update(servicePrice);
	}

	@Override
	public void delete(ServicePrice servicePrice)
	{
		session().delete(servicePrice);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServicePrice> getAll()
	{
		return session().createCriteria(ServicePrice.class).list();
	}

	@Override
	public ServicePrice getById(Short id)
	{
		Criteria crit = session().createCriteria(ServicePrice.class);
		crit.add(Restrictions.idEq(id));
		return (ServicePrice) crit.uniqueResult();
	}

	@Override
	public ServicePrice getLastestServicePrice(Service service)
	{
		String hSql = "select s from ServicePrice s where s.service = :service s.updatedDate = (select max(s.updatedDate) from ServicePrice s";
		Query query = session().createQuery(hSql);
		query.setParameter("service", service);
		return (ServicePrice) query.uniqueResult();
	}
}
