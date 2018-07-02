package com.apartment.management.dao.imp.building;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.building.CriteriaApartmentTypeDaoInf;
import com.apartment.management.model.building.CriteriaApartmentType;

@Component
@Repository
public class CriteriaApartmentTypeDao implements CriteriaApartmentTypeDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(CriteriaApartmentType criteriaApartmentType)
	{
		session().persist(criteriaApartmentType);
	}

	@Override
	public void update(CriteriaApartmentType criteriaApartmentType)
	{
		session().update(criteriaApartmentType);
	}

	@Override
	public void delete(CriteriaApartmentType criteriaApartmentType)
	{
		session().delete(criteriaApartmentType);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CriteriaApartmentType> getAll()
	{
		return session().createCriteria(CriteriaApartmentType.class).list();
	}

	@Override
	public CriteriaApartmentType getById(Short id)
	{
		Criteria crit = session().createCriteria(CriteriaApartmentType.class);
		crit.add(Restrictions.idEq(id));
		return (CriteriaApartmentType) crit.uniqueResult();
	}
}
