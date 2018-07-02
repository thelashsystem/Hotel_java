package com.apartment.management.dao.imp.account;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.account.MessageDaoInf;
import com.apartment.management.model.account.Message;

@Component
@Repository
public class MessageDao implements MessageDaoInf
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(Message message)
	{
		session().persist(message);
	}

	@Override
	public void update(Message message)
	{
		session().update(message);
	}

	@Override
	public void delete(Message message)
	{
		session().delete(message);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> getAll()
	{
		return session().createCriteria(Message.class).list();
	}

	@Override
	public Message getById(Integer id)
	{
		Criteria crit = session().createCriteria(Message.class);
		crit.add(Restrictions.idEq(id));
		return (Message) crit.uniqueResult();
	}
}
