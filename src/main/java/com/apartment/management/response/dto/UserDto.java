package com.apartment.management.response.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.apartment.management.model.account.Account;

public class UserDto implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String email;
	private String fullName;
	private String authority;
	private String permission;
	private String createdDate;
	private String active;
	private String status;
	@Autowired
	@Qualifier("dateFormat_MMddyyyy_hhmm")
	private SimpleDateFormat dateFormat;

	public UserDto()
	{
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getFullName()
	{
		return fullName;
	}

	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}

	public String getAuthority()
	{
		return authority;
	}

	public void setAuthority(String authority)
	{
		this.authority = authority;
	}

	public String getPermission()
	{
		return permission;
	}

	public void setPermission(String permission)
	{
		this.permission = permission;
	}

	public String getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate)
	{
		this.createdDate = dateFormat.format(createdDate);
	}

	public String getActive()
	{
		return active;
	}

	public void setActive(String active)
	{
		this.active = active;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public static UserDto map(Account user)
	{
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setCreatedDate(user.getCreatedDate());
		userDto.setAuthority(user.getAuthorityGroup().getName());
		userDto.setEmail(user.getEmail());
		// userDto.setFullName(user.get);

		return userDto;
	}

	public static List<UserDto> map(List<Account> accounts)
	{
		List<UserDto> listUserDto = new ArrayList<>();
		for ( Account account : accounts )
		{
			listUserDto.add(map(account));
		}
		return listUserDto;
	}
}
