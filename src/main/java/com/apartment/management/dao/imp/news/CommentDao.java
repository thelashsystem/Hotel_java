package com.apartment.management.dao.imp.news;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.news.CommentDaoInf;
import com.apartment.management.model.news.Comment;

@Component
@Repository
public class CommentDao implements CommentDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(Comment comment)
	{
		session().persist(comment);
	}

	@Override
	public void update(Comment comment)
	{
		session().update(comment);
	}

	@Override
	public void delete(Comment comment)
	{
		session().delete(comment);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getAll()
	{
		return session().createCriteria(Comment.class).list();
	}

	@Override
	public Comment getById(Long id)
	{
		Criteria crit = session().createCriteria(Comment.class);
		crit.add(Restrictions.idEq(id));
		return (Comment) crit.uniqueResult();
	}
}
