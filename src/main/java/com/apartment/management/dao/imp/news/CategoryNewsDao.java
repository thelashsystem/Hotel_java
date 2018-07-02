package com.apartment.management.dao.imp.news;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.news.CategoryNewsDaoInf;
import com.apartment.management.model.business.ResourcePrice;
import com.apartment.management.model.news.CategoryNews;

@Component
@Repository
public class CategoryNewsDao implements CategoryNewsDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(CategoryNews categoryNews)
	{
		session().persist(categoryNews);
	}

	@Override
	public void update(CategoryNews categoryNews)
	{
		session().update(categoryNews);
	}

	@Override
	public void delete(CategoryNews categoryNews)
	{
		session().delete(categoryNews);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryNews> getAll()
	{
		return session().createCriteria(ResourcePrice.class).list();
	}

	@Override
	public CategoryNews getById(Short id)
	{
		Criteria crit = session().createCriteria(CategoryNews.class);
		crit.add(Restrictions.idEq(id));
		return (CategoryNews) crit.uniqueResult();
	}
}
