package com.apartment.management.dao.imp.building;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.building.ApartmentTypeDaoInf;
import com.apartment.management.model.building.ApartmentType;

@Component
@Repository
public class ApartmentTypeDao implements ApartmentTypeDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(ApartmentType apartmentType)
	{
		session().persist(apartmentType);
	}

	@Override
	public void update(ApartmentType apartmentType)
	{
		session().update(apartmentType);
	}

	@Override
	public void delete(ApartmentType apartmentType)
	{
		session().delete(apartmentType);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ApartmentType> getAll()
	{
		return session().createCriteria(ApartmentType.class).list();
	}

	@Override
	public ApartmentType getById(Short id)
	{
		Criteria criteria = session().createCriteria(ApartmentType.class);
		criteria.add(Restrictions.idEq(id));
		return (ApartmentType) criteria.uniqueResult();
	}

	@Override
	public ApartmentType getApartmentTypeByCode(String code)
	{
		Criteria criteria = session().createCriteria(ApartmentType.class);
		criteria.add(Restrictions.eq("code", code));
		return (ApartmentType) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ApartmentType> get3HighestApartmentType()
	{
		Criteria criteria = session().createCriteria(ApartmentType.class);
		criteria.addOrder(Order.asc("orderNum"));
		criteria.setMaxResults(3);
		return criteria.list();
	}
}
