package com.apartment.management.dao.interfaces;

import java.util.List;

public interface GeneralDao<T, N extends Number>
{
	public void add(T obj);

	public void update(T obj);

	public void delete(T obj);

	public List<T> getAll();

	public T getById(N id);
}
