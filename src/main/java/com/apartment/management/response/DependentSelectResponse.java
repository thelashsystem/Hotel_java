package com.apartment.management.response;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DependentSelectResponse<T>
{
	private List<T> output;
	private String selected;

	public DependentSelectResponse()
	{
	}

	public List<T> getOutput()
	{
		return output;
	}

	public void setOutput(List<T> output)
	{
		this.output = output;
	}

	public String getSelected()
	{
		return selected;
	}

	public void setSelected(String selected)
	{
		this.selected = selected;
	}

}
