package com.apartment.management.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apartment.management.model.news.News;
import com.apartment.management.response.DatatableResponse;
import com.apartment.management.response.StatusResponse;
import com.apartment.management.response.dto.NewsDto;
import com.apartment.management.service.interfaces.news.NewsService;

@Controller
@RequestMapping("website/news")
public class NewsController
{
	@Autowired
	private NewsService newsService;

	@RequestMapping(value = "news-list", method = RequestMethod.GET)
	public String doView()
	{
		return "news-list";
	}

	@RequestMapping(value = "news-detail", method = RequestMethod.GET)
	public String doDetailView()
	{
		return "redirect:news-list";
	}

	@RequestMapping(value = "news-detail", params = "id", method = RequestMethod.GET)
	public String doDetailView(@RequestParam(value = "id") String id, Model m)
	{
		News news = newsService.getById(Integer.parseInt(id));
		m.addAttribute("news", news);
		return "news-detail";
	}

	@RequestMapping(value = "news-detail", method = RequestMethod.POST)
	public String doUpdateDetailView(@ModelAttribute(value = "news") News news,
			BindingResult rs)
	{
		if ( !rs.hasErrors() )
		{
			newsService.update(news);
		} else
		{
			return "news-detail";
		}
		return "news-detail";
	}

	// @RequestMapping(value = "addNews", method = RequestMethod.GET)
	// public String doAddDetailView(Model m)
	// {
	// m.addAttribute("news", news);
	// return "news-detail";
	// }

	// @RequestMapping(value = "addNews", method = RequestMethod.POST)
	// public String doAddDetailView(@ModelAttribute(value="news")News news,
	// BindingResult rs)
	// {
	// if (!rs.hasErrors()) {
	// newsService.add(news);
	// } else {
	// return "news-detail";
	// }
	// return "news-detail";
	// }

	@RequestMapping(value = "getAllNews", method = RequestMethod.GET)
	@ResponseBody
	private DatatableResponse<NewsDto> getAllNews()
	{
		DatatableResponse<NewsDto> response = new DatatableResponse<>();
		List<News> listNews = newsService.getAll();
		List<NewsDto> listNewsDto = NewsDto.map(listNews);
		response.setAaData(listNewsDto);
		return response;
	}

	@RequestMapping(value = "addNews", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<News> doAdd()
	{
		return new StatusResponse<>();
	}

	@RequestMapping(value = "updateNews", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<News> doUpdate()
	{
		return new StatusResponse<News>();
	}

	@RequestMapping(value = "deleteNews", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<News> doDelete()
	{
		return new StatusResponse<News>();
	}
}
