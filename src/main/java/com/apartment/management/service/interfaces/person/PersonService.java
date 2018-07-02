package com.apartment.management.service.interfaces.person;

import com.apartment.management.model.person.Person;
import com.apartment.management.service.interfaces.GeneralService;

public interface PersonService<T extends Person> extends
		GeneralService<T, Integer>
{

}
