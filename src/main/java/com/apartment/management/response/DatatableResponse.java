package com.apartment.management.response;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DatatableResponse<T>
{
	int iTotalRecords;

	int iTotalDisplayRecords;

	String sEcho;

	String sColumns;

	List<T> aaData;

	public DatatableResponse()
	{
	}

	public DatatableResponse(int iTotalRecords, int iTotalDisplayRecords,
			String sEcho, String sColumns, List<T> aaData)
	{
		this.iTotalRecords = iTotalRecords;
		this.iTotalDisplayRecords = iTotalDisplayRecords;
		this.sEcho = sEcho;
		this.sColumns = sColumns;
		this.aaData = aaData;
	}

	public int getiTotalRecords()
	{
		return iTotalRecords;
	}

	public void setiTotalRecords(int iTotalRecords)
	{
		this.iTotalRecords = iTotalRecords;
	}

	public int getiTotalDisplayRecords()
	{
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(int iTotalDisplayRecords)
	{
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public String getsEcho()
	{
		return sEcho;
	}

	public void setsEcho(String sEcho)
	{
		this.sEcho = sEcho;
	}

	public String getsColumns()
	{
		return sColumns;
	}

	public void setsColumns(String sColumns)
	{
		this.sColumns = sColumns;
	}

	public List<T> getAaData()
	{
		return aaData;
	}

	public void setAaData(List<T> aaData)
	{
		this.aaData = aaData;
	}

}
