package com.apartment.management.dao.imp.asset;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.asset.ApartmentEquipmentDaoInf;
import com.apartment.management.model.account.AuthorityGroup;
import com.apartment.management.model.asset.ApartmentEquipment;
import com.apartment.management.model.building.Apartment;

@Component
@Repository
public class ApartmentEquipmentDao implements ApartmentEquipmentDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(ApartmentEquipment apartmentEquipment)
	{
		session().persist(apartmentEquipment);
	}

	@Override
	public void update(ApartmentEquipment apartmentEquipment)
	{
		session().update(apartmentEquipment);
	}

	@Override
	public void delete(ApartmentEquipment apartmentEquipment)
	{
		session().delete(apartmentEquipment);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ApartmentEquipment> getAll()
	{
		return session().createCriteria(AuthorityGroup.class).list();
	}

	@Override
	public ApartmentEquipment getById(Integer id)
	{
		Criteria crit = session().createCriteria(ApartmentEquipment.class);
		crit.add(Restrictions.idEq(id));
		return (ApartmentEquipment) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ApartmentEquipment> getUnhiddenEquipmentInApartment(
			Apartment apartment)
	{
		Criteria crit = session().createCriteria(ApartmentEquipment.class);
		crit.add(Restrictions.eq("apartment", apartment));
		crit.add(Restrictions.eq("isHidden", false));
		crit.add(Restrictions.eq("isUsed", true));
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ApartmentEquipment> getAllEquipmentInApartment(
			Apartment apartment)
	{
		Criteria crit = session().createCriteria(ApartmentEquipment.class);
		crit.add(Restrictions.eq("apartment", apartment));
		crit.add(Restrictions.eq("isUsed", true));
		return crit.list();
	}
}
