package com.apartment.management.dao.imp.business;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.business.InvoiceDaoInf;
import com.apartment.management.model.business.Invoice;

@Component
@Repository
public class InvoiceDao implements InvoiceDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(Invoice invoice)
	{
		session().persist(invoice);
	}

	@Override
	public void update(Invoice invoice)
	{
		session().update(invoice);
	}

	@Override
	public void delete(Invoice invoice)
	{
		session().delete(invoice);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Invoice> getAll()
	{
		return session().createCriteria(Invoice.class).list();
	}

	@Override
	public Invoice getById(Long id)
	{
		Criteria crit = session().createCriteria(Invoice.class);
		crit.add(Restrictions.idEq(id));
		return (Invoice) crit.uniqueResult();
	}
}
