package com.apartment.management.response.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.apartment.management.model.news.News;

public class NewsDto implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String title;
	private String postedDate;
	private String category;
	private String user;
	private String status;
	@Autowired
	@Qualifier("dateFormat_MMddyyyy_hhmm")
	private SimpleDateFormat dateFormat;


	public NewsDto()
	{
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getPostedDate()
	{
		return postedDate;
	}

	public void setPostedDate(Timestamp postedDate)
	{

		this.postedDate = dateFormat.format(postedDate);
	}

	public void setPostedDate(String postedDate)
	{
		this.postedDate = postedDate;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public String getUser()
	{
		return user;
	}

	public void setUser(String user)
	{
		this.user = user;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public static NewsDto map(News news)
	{
		NewsDto newsDto = new NewsDto();
		newsDto.setId(news.getId());
		newsDto.setTitle(news.getTitle());
//		newsDto.setCategory(news.getCategory().getName());
		newsDto.setPostedDate(news.getPostedDate());
		// newsDto.setUser(user);
		// newsDto.setStatus();

		return newsDto;
	}

	public static List<NewsDto> map(List<News> listNews)
	{
		List<NewsDto> listNewsDto = new ArrayList<>();
		for ( News news : listNews )
		{
			listNewsDto.add(map(news));
		}
		return listNewsDto;
	}

}
