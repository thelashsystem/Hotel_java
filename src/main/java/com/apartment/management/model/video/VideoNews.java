package com.apartment.management.model.video;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.apartment.management.model.news.News;

@Entity
@Table(name = "Video_News")
public class VideoNews extends Video
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne(cascade = CascadeType.ALL)
	private News news;

	public VideoNews()
	{
	}

	public News getNews()
	{
		return news;
	}

	public void setNews(News news)
	{
		this.news = news;
	}

}
