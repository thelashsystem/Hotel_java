package com.apartment.management.dao.imp.setting;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.setting.SettingDaoInf;
import com.apartment.management.model.setting.Setting;

@Component
@Repository
public class SettingDao implements SettingDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(Setting setting)
	{
		session().persist(setting);
	}

	@Override
	public void update(Setting setting)
	{
		session().update(setting);
	}

	@Override
	public void delete(Setting setting)
	{
		session().delete(setting);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Setting> getAll()
	{
		return session().createCriteria(Setting.class).list();
	}

	@Override
	public Setting getById(Short id)
	{
		Criteria crit = session().createCriteria(Setting.class);
		crit.add(Restrictions.idEq(id));
		return (Setting) crit.uniqueResult();
	}
}
