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

import com.apartment.management.dao.interfaces.building.FloorDaoInf;
import com.apartment.management.model.building.Building;
import com.apartment.management.model.building.Floor;

@Component
@Repository
public class FloorDao implements FloorDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(Floor floor)
	{
		session().persist(floor);
	}

	@Override
	public void update(Floor floor)
	{
		session().update(floor);
	}

	@Override
	public void delete(Floor floor)
	{
		session().delete(floor);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Floor> getAll()
	{
		return session().createCriteria(Floor.class).list();
	}

	@Override
	public Floor getById(Integer id)
	{
		Criteria crit = session().createCriteria(Floor.class);
		crit.add(Restrictions.idEq(id));
		return (Floor) crit.uniqueResult();
	}

	@Override
	public Byte countNumFloorInBuilding(Building building)
	{
		Query query = session().createQuery("select count(*) from Floor f where f.building = :building");
		query.setParameter("building", building);
		return (Byte) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Floor> getFloorByBuilding(Building building)
	{
		Query query = session().createQuery("select f from Floor f where f.building = :building");
		query.setParameter("building", building);
		return query.list();
	}
}
