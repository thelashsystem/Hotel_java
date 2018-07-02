package com.apartment.management.dao.imp.parkingLot;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.parkingLot.ParkingLotDaoInf;
import com.apartment.management.model.parkingLot.ParkingLot;

@Component
@Repository
public class ParkingLotDao implements ParkingLotDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(ParkingLot parkingLot)
	{
		session().persist(parkingLot);
	}

	@Override
	public void update(ParkingLot parkingLot)
	{
		session().update(parkingLot);
	}

	@Override
	public void delete(ParkingLot parkingLot)
	{
		session().delete(parkingLot);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ParkingLot> getAll()
	{
		return session().createCriteria(ParkingLot.class).list();
	}

	@Override
	public ParkingLot getById(Short id)
	{
		Criteria crit = session().createCriteria(ParkingLot.class);
		crit.add(Restrictions.idEq(id));
		return (ParkingLot) crit.uniqueResult();
	}
}
