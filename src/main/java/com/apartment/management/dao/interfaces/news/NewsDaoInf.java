package com.apartment.management.dao.interfaces.news;

import java.util.List;

import com.apartment.management.dao.interfaces.GeneralDao;
import com.apartment.management.model.news.News;

public interface NewsDaoInf extends GeneralDao<News, Integer>
{
	public List<News> getLastestNews();
	
	public List<News> get3LastestNews();
	
	public List<Object[]> getCountEachCategory();
	
	public List<Object[]> getCountEachMonthYear();
	
}
