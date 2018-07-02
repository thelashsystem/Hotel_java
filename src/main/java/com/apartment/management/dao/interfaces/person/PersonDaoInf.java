package com.apartment.management.dao.interfaces.person;

import com.apartment.management.dao.interfaces.GeneralDao;
import com.apartment.management.model.person.Person;

public interface PersonDaoInf<T extends Person> extends GeneralDao<T, Integer>
{

}
