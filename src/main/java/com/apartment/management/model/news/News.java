package com.apartment.management.model.news;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.apartment.management.model.account.EmployeeAccount;
import com.apartment.management.model.image.ImageNews;
import com.apartment.management.model.video.VideoNews;

@Entity
@Table(name = "News")
public class News implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(length = 100)
	private String title;
	@Column(columnDefinition="datetime")
	private Timestamp postedDate;
	@Column(columnDefinition = "text")
	private String content;
	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "news", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OrderBy(value = "orderNum")
	private List<ImageNews> images;
	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "news", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<VideoNews> videos;
	@ManyToOne(cascade = CascadeType.ALL)
	private CategoryNews category;
	@Fetch(FetchMode.SELECT)
	@OrderBy(value="postedDate")
	@OneToMany(mappedBy = "news", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Comment> comments;
	@ManyToOne(cascade = CascadeType.ALL)
	private EmployeeAccount employeeAccount;
	@Column(length = 255)
	private String shortDescription;
	private Integer status;
	@Transient
	private Map<Integer, String> statusReferences;

	public News()
	{
		statusReferences = new TreeMap<>();
		statusReferences.put(0, "Available");
		statusReferences.put(1, "Not Available");
		statusReferences.put(2, "Hidden");
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public Timestamp getPostedDate()
	{
		return postedDate;
	}

	public void setPostedDate(Timestamp postedDate)
	{
		this.postedDate = postedDate;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public List<ImageNews> getImages()
	{
		return images;
	}

	public void setImages(List<ImageNews> images)
	{
		this.images = images;
	}

	public List<VideoNews> getVideos()
	{
		return videos;
	}

	public void setVideos(List<VideoNews> videos)
	{
		this.videos = videos;
	}

	public CategoryNews getCategory()
	{
		return category;
	}

	public void setCategory(CategoryNews category)
	{
		this.category = category;
	}

	public List<Comment> getComments()
	{
		return comments;
	}

	public void setComments(List<Comment> comments)
	{
		this.comments = comments;
	}

	public String getStatus()
	{
		return statusReferences.get(status);
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public String getShortDescription()
	{
		return shortDescription;
	}

	public void setShortDescription(String shortDescription)
	{
		this.shortDescription = shortDescription;
	}

	public EmployeeAccount getEmployeeAccount()
	{
		return employeeAccount;
	}

	public void setEmployeeAccount(EmployeeAccount employeeAccount)
	{
		this.employeeAccount = employeeAccount;
	}

}
