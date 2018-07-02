package com.apartment.management.service.imp.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.imp.news.NewsDao;
import com.apartment.management.model.news.CategoryNews;
import com.apartment.management.model.news.News;
import com.apartment.management.repository.NewsRepository;
import com.apartment.management.service.interfaces.news.NewsService;

@Component
@Service
@Transactional
public class NewsServiceImp implements NewsService
{
	@Autowired
	private NewsDao newsDao;
	
	@Autowired
	private NewsRepository newsRepository;

	@Override
	public void add(News news)
	{
		newsDao.add(news);
	}

	@Override
	public void update(News news)
	{
		newsDao.update(news);
	}

	@Override
	public void delete(News news)
	{
		newsDao.delete(news);
	}

	@Override
	public List<News> getAll()
	{
		return newsDao.getAll();
	}

	@Override
	public News getById(Integer id)
	{
		return newsDao.getById(id);
	}

	@Override
	public List<News> getLastestNews()
	{
		return newsDao.getLastestNews();
	}
	
	@Override
	public Page<News> getLastestNews(Pageable pageable) {
		return newsRepository.findAll(pageable);
	}

	@Override
	public List<News> get3LastestNews()
	{
		return newsDao.get3LastestNews();
	}

	@Override
	public List<Object[]> getCountEachCategory()
	{
		return newsDao.getCountEachCategory();
	}

	@Override
	public List<Object[]> getCountEachMonthYear()
	{
		return newsDao.getCountEachMonthYear();
	}

	@Override
	public Page<News> getNewsByCategory(CategoryNews category, Pageable pageable)
	{
		return newsRepository.findByCategory(category, pageable);
	}

	@Override
	public Page<News> getNewsByMonthYear(String date, Pageable pageable)
	{
		return newsRepository.findByDate(date, pageable);
	}
}
