package com.apartment.management.service.interfaces.news;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.apartment.management.model.news.CategoryNews;
import com.apartment.management.model.news.News;
import com.apartment.management.service.interfaces.GeneralService;

public interface NewsService extends GeneralService<News, Integer>
{
	public List<News> getLastestNews();

	public Page<News> getLastestNews(Pageable pageable);

	public List<News> get3LastestNews();

	public List<Object[]> getCountEachCategory();

	public List<Object[]> getCountEachMonthYear();

	public Page<News> getNewsByCategory(CategoryNews category, Pageable pageable);

	public Page<News> getNewsByMonthYear(String date, Pageable pageable);

}
