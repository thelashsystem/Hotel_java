package com.apartment.management.service.imp.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.imp.news.CommentDao;
import com.apartment.management.model.news.Comment;
import com.apartment.management.service.interfaces.news.CommentService;

@Component
@Service
@Transactional
public class CommentServiceImp implements CommentService
{
	@Autowired
	private CommentDao commentDao;

	@Override
	public void add(Comment comment)
	{
		commentDao.add(comment);
	}

	@Override
	public void update(Comment comment)
	{
		commentDao.update(comment);
	}

	@Override
	public void delete(Comment comment)
	{
		commentDao.delete(comment);
	}

	@Override
	public List<Comment> getAll()
	{
		return commentDao.getAll();
	}

	@Override
	public Comment getById(Long id)
	{
		return commentDao.getById(id);
	}

}
