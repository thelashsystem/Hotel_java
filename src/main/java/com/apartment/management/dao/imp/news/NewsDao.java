package com.apartment.management.dao.imp.news;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.news.NewsDaoInf;
import com.apartment.management.model.news.News;

@Component
@Repository
public class NewsDao implements NewsDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(News news)
	{
		session().persist(news);
	}

	@Override
	public void update(News news)
	{
		session().update(news);
	}

	@Override
	public void delete(News news)
	{
		session().delete(news);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getAll()
	{
		return session().createCriteria(News.class).list();
	}

	@Override
	public News getById(Integer id)
	{
		Criteria crit = session().createCriteria(News.class);
		crit.add(Restrictions.idEq(id));
		return (News) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getLastestNews()
	{
		return session().createQuery("from News n order by n.postedDate desc").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> get3LastestNews()
	{
		return session().createQuery("from News n order by n.postedDate desc").setMaxResults(3).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getCountEachCategory() {
		return session().createQuery("select n.category.id, n.category.name, count(n.id) from News n group by category").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getCountEachMonthYear()
	{
		return session().createQuery("select DATE_FORMAT(n.postedDate, '%M %Y'), count(n.id) from News n group by  DATE_FORMAT(n.postedDate, '%M %Y')").list();
	}
}
