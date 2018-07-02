package com.apartment.management.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class StatusResponse<T>
{
	private Boolean success;
	private T object;
	private List<T> objects;
	private List<String> message;

	public StatusResponse()
	{
		this.message = new ArrayList<String>();
	}

	public StatusResponse(Boolean success)
	{
		this.success = success;
		this.message = new ArrayList<String>();
	}

	public StatusResponse(Boolean success, String message)
	{
		this.success = success;
		this.message = new ArrayList<String>();
		this.message.add(message);
	}

	public StatusResponse(Boolean success, List<String> message)
	{
		this.success = success;
		this.message = message;
	}

	public StatusResponse(Boolean success, T object)
	{
		this(success);
		this.object = object;
	}

	public Boolean getSuccess()
	{
		return success;
	}

	public void setSuccess(Boolean success)
	{
		this.success = success;
	}

	public List<String> getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = new ArrayList<String>();
		this.message.add(message);
	}

	public Object getObject()
	{
		return object;
	}

	public void setObject(T object)
	{
		this.object = object;
	}

	public void setMessage(List<String> message)
	{
		this.message = message;
	}

	public void addMessage(String message)
	{
		this.message.add(message);
	}

	public List<T> getObjects()
	{
		return objects;
	}

	public void setObjects(List<T> objects)
	{
		this.objects = objects;
	}

}
