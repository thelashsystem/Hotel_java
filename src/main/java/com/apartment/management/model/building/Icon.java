package com.apartment.management.model.building;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Icon")
public class Icon implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Short id;
	@Column(length = 50)
	private String name;
	@Column(length = 50)
	private String code;
	@Column(columnDefinition = "text")
	private String description;
	@OneToMany(mappedBy = "icon", cascade = CascadeType.ALL)
	private Set<CriteriaApartmentType> criterias;
	private Integer status;
	@Transient
	private Map<Integer, String> statusReferences;

	public Icon()
	{
		statusReferences = new TreeMap<>();
		statusReferences.put(0, "Available");
		statusReferences.put(1, "Hidden");
	}

	public Short getId()
	{
		return id;
	}

	public void setId(Short id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	@JsonIgnore
	public Set<CriteriaApartmentType> getCriterias()
	{
		return criterias;
	}

	public void setCriterias(Set<CriteriaApartmentType> criterias)
	{
		this.criterias = criterias;
	}

	public String getStatus()
	{
		return statusReferences.get(status);
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

}
