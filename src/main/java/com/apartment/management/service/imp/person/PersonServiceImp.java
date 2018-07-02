package com.apartment.management.service.imp.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.imp.person.PersonDao;
import com.apartment.management.model.person.Person;
import com.apartment.management.service.interfaces.person.PersonService;

@Service
@Transactional
public abstract class PersonServiceImp<T extends Person> implements
		PersonService<T>
{
	@Autowired
	private PersonDao<T> personDao;

	@Override
	public void add(T person)
	{
		personDao.add(person);
	}

	@Override
	public void update(T person)
	{
		personDao.update(person);
	}

	@Override
	public void delete(T person)
	{
		personDao.delete(person);
	}

	@Override
	public List<T> getAll()
	{
		return personDao.getAll();
	}

	@Override
	public T getById(Integer id)
	{
		return personDao.getById(id);
	}
}
