package com.apartment.management.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.apartment.management.model.building.Building;

public class ApartmentValidation implements Validator
{

	@Override
	public boolean supports(Class<?> arg0)
	{
		return Building.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors err)
	{

	}

}
