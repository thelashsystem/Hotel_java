package com.apartment.management.model.setting;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Setting")
public class Setting implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Short id;
	@Column(length = 100)
	private String companyName;
	private String mainAddress;
	@Column(length = 30)
	private String mainPhone;
	private String imagePathLogo;
	private String facebookFanPageLink;
	private String twitterFanPageLink;
	private String youTubeLink;
	private String officalEmail;
	@Column(length = 30)
	private String hotLine;
	@Column(length = 100)
	private String website;
	@Column(columnDefinition = "text")
	private String descriptionAboutUs;
	@Column(columnDefinition = "text")
	private String descriptionAboutNews;

	public Setting()
	{
	}

	public Short getId()
	{
		return id;
	}

	public void setId(Short id)
	{
		this.id = id;
	}

	public String getCompanyName()
	{
		return companyName;
	}

	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}

	public String getMainAddress()
	{
		return mainAddress;
	}

	public void setMainAddress(String mainAddress)
	{
		this.mainAddress = mainAddress;
	}

	public String getMainPhone()
	{
		return mainPhone;
	}

	public void setMainPhone(String mainPhone)
	{
		this.mainPhone = mainPhone;
	}

	public String getImagePathLogo()
	{
		return imagePathLogo;
	}

	public void setImagePathLogo(String imagePathLogo)
	{
		this.imagePathLogo = imagePathLogo;
	}

	public String getFacebookFanPageLink()
	{
		return facebookFanPageLink;
	}

	public void setFacebookFanPageLink(String facebookFanPageLink)
	{
		this.facebookFanPageLink = facebookFanPageLink;
	}

	public String getTwitterFanPageLink()
	{
		return twitterFanPageLink;
	}

	public void setTwitterFanPageLink(String twitterFanPageLink)
	{
		this.twitterFanPageLink = twitterFanPageLink;
	}

	public String getYouTubeLink()
	{
		return youTubeLink;
	}

	public void setYouTubeLink(String youTubeLink)
	{
		this.youTubeLink = youTubeLink;
	}

	public String getOfficalEmail()
	{
		return officalEmail;
	}

	public void setOfficalEmail(String officalEmail)
	{
		this.officalEmail = officalEmail;
	}

	public String getHotLine()
	{
		return hotLine;
	}

	public void setHotLine(String hotLine)
	{
		this.hotLine = hotLine;
	}

	public String getWebsite()
	{
		return website;
	}

	public void setWebsite(String website)
	{
		this.website = website;
	}

	public String getDescriptionAboutUs()
	{
		return descriptionAboutUs;
	}

	public void setDescriptionAboutUs(String descriptionAboutUs)
	{
		this.descriptionAboutUs = descriptionAboutUs;
	}

	public String getDescriptionAboutNews()
	{
		return descriptionAboutNews;
	}

	public void setDescriptionAboutNews(String descriptionAboutNews)
	{
		this.descriptionAboutNews = descriptionAboutNews;
	}

}
