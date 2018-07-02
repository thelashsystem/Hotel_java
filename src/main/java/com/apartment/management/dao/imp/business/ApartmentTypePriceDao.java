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

import com.apartment.management.dao.interfaces.business.ApartmentTypePriceDaoInf;
import com.apartment.management.model.building.ApartmentType;
import com.apartment.management.model.business.ResourcePrice;
import com.apartment.management.model.business.ApartmentTypePrice;

@Component
@Repository
public class ApartmentTypePriceDao implements ApartmentTypePriceDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(ApartmentTypePrice apartmentTypePrice)
	{
		session().persist(apartmentTypePrice);
	}

	@Override
	public void update(ApartmentTypePrice apartmentTypePrice)
	{
		session().update(apartmentTypePrice);
	}

	@Override
	public void delete(ApartmentTypePrice apartmentTypePrice)
	{
		session().delete(apartmentTypePrice);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ApartmentTypePrice> getAll()
	{
		return session().createCriteria(ResourcePrice.class).list();
	}

	@Override
	public ApartmentTypePrice getById(Integer id)
	{
		Criteria crit = session().createCriteria(ApartmentTypePrice.class);
		crit.add(Restrictions.idEq(id));
		return (ApartmentTypePrice) crit.uniqueResult();
	}

	@Override
	public ApartmentTypePrice getLastestApartmentTypePrice(
			ApartmentType apartmentType)
	{
		String hSql = "select a from ApartmentTypePrice a where a.apartmentType = :apartmentType and a.updatedDate =  (select max(a.updatedDate) from ApartmentTypePrice a)";
		Query query = session().createQuery(hSql);
		query.setParameter("apartmentType", apartmentType);
		return (ApartmentTypePrice) query.uniqueResult();
	}
}
