package com.apartment.management.controller.view;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apartment.management.model.building.ApartmentType;
import com.apartment.management.model.news.CategoryNews;
import com.apartment.management.model.news.News;
import com.apartment.management.service.interfaces.building.ApartmentTypeService;
import com.apartment.management.service.interfaces.news.CategoryNewsService;
import com.apartment.management.service.interfaces.news.NewsService;

@Controller
public class NewsViewController
{
	@Autowired
	private ApartmentTypeService apartmentTypeService;

	@Autowired
	private NewsService newsService;

	@Autowired
	private CategoryNewsService categoryNewsService;

	@RequestMapping(value = "news-list", method = RequestMethod.GET)
	private String doViewNews(Model m, HttpServletRequest request)
	{
		PageRequest paging = new PageRequest(0, 5);
		getDefaultData(m);
		Page<News> news = newsService.getLastestNews(paging);
		m.addAttribute("listNews", news);
		getInformationForAside(m);
		String url = request.getServletPath();
		m.addAttribute("url", url);
		return "news-list";
	}

	@RequestMapping(value = "news-list", params = "page", method = RequestMethod.GET)
	private String doViewNewsByPage(@RequestParam(value = "page") String page,
			HttpServletRequest request, Model m)
	{
		PageRequest paging = new PageRequest(Integer.parseInt(page) - 1, 5);
		getDefaultData(m);
		Page<News> listNews = newsService.getLastestNews(paging);
		m.addAttribute("listNews", listNews);
		getInformationForAside(m);
		String url = request.getServletPath();
		m.addAttribute("url", url);
		return "news-list";
	}

	@RequestMapping(value = "category/{categoryName}-{categoryId}/news-list", method = RequestMethod.GET)
	private String doCategoryNewsView(
			@PathVariable(value = "categoryName") String categoryName,
			@PathVariable(value = "categoryId") String categoryId, Model m,
			HttpServletRequest request)
	{
		PageRequest paging = new PageRequest(0, 5);
		CategoryNews category = categoryNewsService.getById(Short
				.parseShort(categoryId));
		getDefaultData(m);
		Page<News> listNews = newsService.getNewsByCategory(category, paging);
		m.addAttribute("listNews", listNews);
		getInformationForAside(m);
		String url = request.getServletPath();
		m.addAttribute("url", url);
		return "news-list";
	}

	@RequestMapping(value = "category/{categoryName}-{categoryId}/news-list", params = "page", method = RequestMethod.GET)
	private String doCategoryNewsViewByPage(
			@PathVariable(value = "categoryName") String categoryName,
			@PathVariable(value = "categoryId") String categoryId,
			@RequestParam(value = "page") String page,
			HttpServletRequest request, Model m)
	{
		PageRequest paging = new PageRequest(Integer.parseInt(page) - 1, 5);
		CategoryNews category = categoryNewsService.getById(Short
				.parseShort(categoryId));
		getDefaultData(m);
		Page<News> listNews = newsService.getNewsByCategory(category, paging);
		m.addAttribute("listNews", listNews);
		getInformationForAside(m);
		String url = request.getServletPath();
		m.addAttribute("url", url);
		return "news-list";
	}

	@RequestMapping(value = "archive/{monthYearRequest}/news-list", method = RequestMethod.GET)
	public String getArchiveNews(
			@PathVariable(value = "monthYearRequest") String monthYearRequest,
			HttpServletRequest request, Model m)
	{
		getInformationForAside(m);
		// try
		// {
		PageRequest paging = new PageRequest(0, 5);
		Page<News> listNews = newsService.getNewsByMonthYear(monthYearRequest,
				paging);
		m.addAttribute("listNews", listNews);
		// } catch (ParseException e)
		// {
		// e.printStackTrace();
		// return "redirect:news-list.html";
		// }
		String url = request.getServletPath();
		m.addAttribute("url", url);
		return "news-list";
	}

	@RequestMapping(value = "archive/{monthYearRequest}/news-list", params = "page", method = RequestMethod.GET)
	public String getArchiveNewsByPage(
			@PathVariable(value = "monthYearRequest") String monthYearRequest,
			HttpServletRequest request,
			@RequestParam(value = "page") String page, Model m)
	{
		getInformationForAside(m);
		// try
		// {
		PageRequest paging = new PageRequest(Integer.parseInt(page) - 1, 5);
		Page<News> listNews = newsService.getNewsByMonthYear(monthYearRequest,
				paging);
		m.addAttribute("listNews", listNews);
		// } catch (ParseException e)
		// {
		// e.printStackTrace();
		// return "redirect:news-list.html";
		// }
		String url = request.getServletPath();
		m.addAttribute("url", url);
		return "news-list";
	}

	@RequestMapping(value = "news-detail", params = "id", method = RequestMethod.GET)
	private String doViewNewsDetail(@RequestParam(value = "id") String id,
			Model m)
	{
		getDefaultData(m);
		News news = newsService.getById(Integer.parseInt(id.split("#")[0]));
		getInformationForAside(m);
		m.addAttribute("news", news);
		return "news-detail";
	}

	@RequestMapping(value = "news-detail", method = RequestMethod.GET)
	private String doNewsDetail(Model m)
	{
		return "redirect:news-list.html";
	}

	private void getDefaultData(Model m)
	{
		String language = LocaleContextHolder.getLocale().getLanguage();
		List<ApartmentType> listApartmentType = apartmentTypeService
				.getAllApartmentType();
		m.addAttribute("listApartmentType", listApartmentType);
		m.addAttribute("language", language);
	}

	private void getInformationForAside(Model m)
	{
		List<News> list3LastestNews = newsService.get3LastestNews();
		List<Object[]> countNewsCategory = newsService.getCountEachCategory();
		List<Object[]> countNewsYearMonth = newsService.getCountEachMonthYear();
		m.addAttribute("list3LastestNews", list3LastestNews);
		m.addAttribute("countNewsCategory", countNewsCategory);
		m.addAttribute("countNewsYearMonth", countNewsYearMonth);
	}

}
