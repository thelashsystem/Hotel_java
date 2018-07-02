package com.apartment.management.dao.imp.building;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.building.ApartmentDaoInf;
import com.apartment.management.model.building.Apartment;
import com.apartment.management.model.building.ApartmentType;

@Component
@Repository
public class ApartmentDao implements ApartmentDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(Apartment apartment)
	{
		session().saveOrUpdate(apartment);
	}

	@Override
	public void update(Apartment apartment)
	{
		session().update(apartment);
	}

	@Override
	public void delete(Apartment apartment)
	{
		session().delete(apartment);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Apartment> getAll()
	{
		return session().createCriteria(Apartment.class).list();
	}

	@Override
	public Apartment getById(Integer id)
	{
		Criteria crit = session().createCriteria(Apartment.class);
		crit.add(Restrictions.idEq(id));
		return (Apartment) crit.uniqueResult();
	}

	@Override
	public List<Apartment> get3PopularApartmentFromApartmentType(
			ApartmentType apartmentType)
	{
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Apartment> get3RandomApartmentFromApartmentType(
			ApartmentType apartmentType)
	{
		String hSql = "select a from Apartment a where a.apartmentType = :apartmentType order by rand()";
		Query query = session().createQuery(hSql);
		query.setParameter("apartmentType", apartmentType);
		query.setMaxResults(3);
		return query.list();
	}

	@Override
	public Apartment getRandomApartmentFromApartmentType(ApartmentType apartmentType)
	{
		String hSql = "select a from Apartment a where a.apartmentType = :apartmentType order by rand()";
		Query query = session().createQuery(hSql);
		query.setParameter("apartmentType", apartmentType);
		query.setMaxResults(1);
		return (Apartment) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Apartment> getAvailableApartment()
	{
		String hSql = "select a from Apartment a where a.status = 0";
		return session().createQuery(hSql).list();
	}
}
