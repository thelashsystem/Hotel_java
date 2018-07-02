package com.apartment.management.model.account;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Account implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false, unique = true, length = 150)
	private String email;
	private String password;
	@Column(columnDefinition = "datetime")
	private Timestamp createdDate;
	private boolean isEnabled;
	@ManyToOne(cascade = CascadeType.ALL)
	private AuthorityGroup authorityGroup;
	@Column(length = 20)
	private String nickName;
	@Column(columnDefinition = "text")
	private String biography;
	private String avatar;
	private Integer status;
	@Transient
	private Map<Integer, String> statusReferences;

	public Account()
	{
		statusReferences = new TreeMap<>();
		statusReferences.put(0, "Available");
		statusReferences.put(1, "Not Available");
		statusReferences.put(2, "Hidden");
		statusReferences.put(3, "Banned");
		statusReferences.put(4, "Not Active");
		statusReferences.put(5, "Unabled");
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

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public boolean isEnabled()
	{
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled)
	{
		this.isEnabled = isEnabled;
	}

	public AuthorityGroup getAuthorityGroup()
	{
		return authorityGroup;
	}

	public void setAuthorityGroup(AuthorityGroup authorityGroup)
	{
		this.authorityGroup = authorityGroup;
	}

	public String getStatus()
	{
		return statusReferences.get(status);
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public Timestamp getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate)
	{
		this.createdDate = createdDate;
	}

	public String getNickName()
	{
		return nickName;
	}

	public void setNickName(String nickName)
	{
		this.nickName = nickName;
	}

	public String getBiography()
	{
		return biography;
	}

	public void setBiography(String biography)
	{
		this.biography = biography;
	}

	public String getAvatar()
	{
		return avatar;
	}

	public void setAvatar(String avatar)
	{
		this.avatar = avatar;
	}

}
