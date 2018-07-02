package com.apartment.management.dao.imp.business;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.business.BillingDaoInf;
import com.apartment.management.model.business.Billing;
import com.apartment.management.model.contract.CustomerContract;

@Component
@Repository
public class BillingDao implements BillingDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(Billing bill)
	{
		session().persist(bill);
	}

	@Override
	public void update(Billing bill)
	{
		session().update(bill);
	}

	@Override
	public void delete(Billing bill)
	{
		session().delete(bill);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Billing> getAll()
	{
		return session().createCriteria(Billing.class).list();
	}

	@Override
	public Billing getById(Integer id)
	{
		Criteria crit = session().createCriteria(Billing.class);
		crit.add(Restrictions.idEq(id));
		return (Billing) crit.uniqueResult();
	}

	@Override
	public Integer createBilling(CustomerContract customerContract)
	{
		Billing billing = new Billing();
		billing.setCreatedDate(new java.sql.Date(new Date().getTime()));
		billing.setCustomerContract(customerContract);
		return (Integer) session().save(billing);
	}
}
