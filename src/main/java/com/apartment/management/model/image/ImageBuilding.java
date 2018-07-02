package com.apartment.management.model.image;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.apartment.management.model.building.Building;

@Entity
@Table(name = "Image_Building")
public class ImageBuilding extends Gallery
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne(cascade = CascadeType.ALL)
	private Building building;

	public ImageBuilding()
	{
	}

	public Building getBuilding()
	{
		return building;
	}

	public void setBuilding(Building building)
	{
		this.building = building;
	}

}
