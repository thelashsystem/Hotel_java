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

import com.apartment.management.dao.interfaces.business.ResourcePriceDaoInf;
import com.apartment.management.model.business.Resource;
import com.apartment.management.model.business.ResourcePrice;

@Component
@Repository
public class ResourcePriceDao implements ResourcePriceDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(ResourcePrice resourcePrice)
	{
		session().persist(resourcePrice);
	}

	@Override
	public void update(ResourcePrice resourcePrice)
	{
		session().update(resourcePrice);
	}

	@Override
	public void delete(ResourcePrice resourcePrice)
	{
		session().delete(resourcePrice);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ResourcePrice> getAll()
	{
		return session().createCriteria(ResourcePrice.class).list();
	}

	@Override
	public ResourcePrice getById(Integer id)
	{
		Criteria crit = session().createCriteria(ResourcePrice.class);
		crit.add(Restrictions.idEq(id));
		return (ResourcePrice) crit.uniqueResult();
	}

	@Override
	public ResourcePrice getLastestResourcePrice(Resource resource)
	{
		String hSql = "select r from ResourcePrice r where r.resource = :resource and r.updatedDate = (select max(r.updatedDate) from ResourcePrice r)";
		Query query = session().createQuery(hSql);
		query.setParameter("resource", resource);
		return (ResourcePrice) query.uniqueResult();
	}
}
