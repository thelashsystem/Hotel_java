package com.apartment.management.dao.imp.asset;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.asset.EquipmentDaoInf;
import com.apartment.management.model.asset.Equipment;

@Component
@Repository
public class EquipmentDao implements EquipmentDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(Equipment equipment)
	{
		session().persist(equipment);
	}

	@Override
	public void update(Equipment equipment)
	{
		session().update(equipment);
	}

	@Override
	public void delete(Equipment equipment)
	{
		session().delete(equipment);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Equipment> getAll()
	{
		return session().createCriteria(Equipment.class).list();
	}

	@Override
	public Equipment getById(Integer id)
	{
		Criteria crit = session().createCriteria(Equipment.class);
		crit.add(Restrictions.idEq(id));
		return (Equipment) crit.uniqueResult();
	}
}
