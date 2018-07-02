package com.apartment.management.service.imp.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.imp.news.CategoryNewsDao;
import com.apartment.management.model.news.CategoryNews;
import com.apartment.management.service.interfaces.news.CategoryNewsService;

@Component
@Service
@Transactional
public class CategoryNewsServiceImp implements CategoryNewsService
{
	@Autowired
	private CategoryNewsDao categoryNewsDao;

	@Override
	public void add(CategoryNews categoryNews)
	{
		categoryNewsDao.add(categoryNews);
	}

	@Override
	public void update(CategoryNews categoryNews)
	{
		categoryNewsDao.update(categoryNews);
	}

	@Override
	public void delete(CategoryNews categoryNews)
	{
		categoryNewsDao.delete(categoryNews);
	}

	@Override
	public List<CategoryNews> getAll()
	{
		return categoryNewsDao.getAll();
	}

	@Override
	public CategoryNews getById(Short id)
	{
		return categoryNewsDao.getById(id);
	}

}
