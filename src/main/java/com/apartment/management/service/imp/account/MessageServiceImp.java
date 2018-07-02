package com.apartment.management.service.imp.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.interfaces.account.MessageDaoInf;
import com.apartment.management.model.account.Message;
import com.apartment.management.service.interfaces.account.MessageService;

@Component
@Service
@Transactional
public class MessageServiceImp implements MessageService
{
	@Autowired
	private MessageDaoInf messageDao;

	@Override
	public void add(Message message)
	{
		messageDao.add(message);
	}

	@Override
	public void update(Message message)
	{
		messageDao.update(message);
	}

	@Override
	public void delete(Message message)
	{
		messageDao.delete(message);
	}

	@Override
	public List<Message> getAll()
	{
		return messageDao.getAll();
	}

	@Override
	public Message getById(Integer id)
	{
		return messageDao.getById(id);
	}
}
