package com.apartment.management.dao.imp.parkingLot;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.parkingLot.OwnerDaoInf;
import com.apartment.management.model.parkingLot.Owner;

@Component
@Repository
public class OwnerDao implements OwnerDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(Owner owner)
	{
		session().persist(owner);
	}

	@Override
	public void update(Owner owner)
	{
		session().update(owner);
	}

	@Override
	public void delete(Owner owner)
	{
		session().delete(owner);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Owner> getAll()
	{
		return session().createCriteria(Owner.class).list();
	}

	@Override
	public Owner getById(Integer id)
	{
		Criteria crit = session().createCriteria(Owner.class);
		crit.add(Restrictions.idEq(id));
		return (Owner) crit.uniqueResult();
	}
}
