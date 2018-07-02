package com.apartment.management.dao.imp.asset;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.asset.SupplierEquipmentDaoInf;
import com.apartment.management.model.asset.SupplierEquipment;

@Component
@Repository
public class SupplierEquipmentDao implements SupplierEquipmentDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(SupplierEquipment supplierEquipment)
	{
		session().persist(supplierEquipment);
	}

	@Override
	public void update(SupplierEquipment supplierEquipment)
	{
		session().update(supplierEquipment);
	}

	@Override
	public void delete(SupplierEquipment supplierEquipment)
	{
		session().delete(supplierEquipment);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SupplierEquipment> getAll()
	{
		return session().createCriteria(SupplierEquipment.class).list();
	}

	@Override
	public SupplierEquipment getById(Integer id)
	{
		Criteria crit = session().createCriteria(SupplierEquipment.class);
		crit.add(Restrictions.idEq(id));
		return (SupplierEquipment) crit.uniqueResult();
	}
}
