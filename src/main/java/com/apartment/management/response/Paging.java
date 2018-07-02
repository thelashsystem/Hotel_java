package com.apartment.management.response;

import org.springframework.stereotype.Component;

@Component
public class Paging
{
	private boolean _search;
	private String filters;
	private Integer page;
	private Integer rows;
	private String sidx;
	private String sord;

	public Paging()
	{

	}

	public Paging(boolean _search, String filters, Integer page, Integer rows,
			String sidx, String sord)
	{
		this._search = _search;
		this.filters = filters;
		this.page = page;
		this.rows = rows;
		this.sidx = sidx;
		this.sord = sord;
	}

	public boolean get_search()
	{
		return _search;
	}

	public void set_search(boolean _search)
	{
		this._search = _search;
	}

	public String getFilters()
	{
		return filters;
	}

	public void setFilters(String filters)
	{
		this.filters = filters;
	}

	public Integer getPage()
	{
		return page;
	}

	public void setPage(Integer page)
	{
		this.page = page;
	}

	public Integer getRows()
	{
		return rows;
	}

	public void setRows(Integer rows)
	{
		this.rows = rows;
	}

	public String getSidx()
	{
		return sidx;
	}

	public void setSidx(String sidx)
	{
		this.sidx = sidx;
	}

	public String getSord()
	{
		return sord;
	}

	public void setSord(String sord)
	{
		this.sord = sord;
	}

}
