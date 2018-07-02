package com.apartment.management.model.person;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

import com.apartment.management.model.street.Address;

@Embeddable
public class PersonalProfile
{
	private String firstName;
	private String lastName;
	@Embedded
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name = "address_person")
	@JoinColumn(name = "person_id")
	private Set<Address> address;
	private String phone;
	private boolean gender;
	private String identityCard;
	private Date birthday;
	private String personalImagePath;

	public PersonalProfile()
	{
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public boolean isGender()
	{
		return gender;
	}

	public void setGender(boolean gender)
	{
		this.gender = gender;
	}

	public Date getBirthday()
	{
		return birthday;
	}

	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}

	public String getIdentityCard()
	{
		return identityCard;
	}

	public void setIdentityCard(String identityCard)
	{
		this.identityCard = identityCard;
	}

	public Set<Address> getAddress()
	{
		return address;
	}

	public void setAddress(Set<Address> address)
	{
		this.address = address;
	}

	public String getPersonalImagePath()
	{
		return personalImagePath;
	}

	public void setPersonalImagePath(String personalImagePath)
	{
		this.personalImagePath = personalImagePath;
	}

}
