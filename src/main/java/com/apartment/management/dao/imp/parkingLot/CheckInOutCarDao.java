package com.apartment.management.dao.imp.parkingLot;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.parkingLot.CheckInOutCarDaoInf;
import com.apartment.management.model.parkingLot.CheckInOutCar;

@Component
@Repository
public class CheckInOutCarDao implements CheckInOutCarDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(CheckInOutCar checkInOutCar)
	{
		session().persist(checkInOutCar);
	}

	@Override
	public void update(CheckInOutCar checkInOutCar)
	{
		session().update(checkInOutCar);
	}

	@Override
	public void delete(CheckInOutCar checkInOutCar)
	{
		session().delete(checkInOutCar);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CheckInOutCar> getAll()
	{
		return session().createCriteria(CheckInOutCar.class).list();
	}

	@Override
	public CheckInOutCar getById(Long id)
	{
		Criteria crit = session().createCriteria(CheckInOutCar.class);
		crit.add(Restrictions.idEq(id));
		return (CheckInOutCar) crit.uniqueResult();
	}
}
