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

import com.apartment.management.model.account.CustomerAccount;
import com.apartment.management.model.account.EmployeeAccount;

@Entity
@Table(name = "Comment")
public class Comment implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(columnDefinition="datetime")
	private Timestamp postedDate;
	@Column(length = 100)
	private String title;
	@Column(columnDefinition = "text")
	private String content;
	private Short likes;
	@ManyToOne(cascade = CascadeType.ALL)
	private News news;
	@ManyToOne(cascade = CascadeType.ALL)
	private CustomerAccount customer;
	@ManyToOne(cascade = CascadeType.ALL)
	private EmployeeAccount employee;
	@OrderBy(value="postedDate")
	@OneToMany(mappedBy = "reply", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Comment> replies;
	private Integer status;
	@Transient
	private Map<Integer, String> statusReferences;

	@ManyToOne(cascade = CascadeType.ALL)
	private Comment reply;

	public Comment()
	{
		statusReferences = new TreeMap<>();
		statusReferences.put(0, "Available");
		statusReferences.put(1, "Not Available");
		statusReferences.put(2, "Hidden");
		statusReferences.put(3, "Pending");
		statusReferences.put(4, "Deleted");
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Timestamp getPostedDate()
	{
		return postedDate;
	}

	public void setPostedDate(Timestamp postedDate)
	{
		this.postedDate = postedDate;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public Short getLikes()
	{
		return likes;
	}

	public void setLikes(Short likes)
	{
		this.likes = likes;
	}

	public News getNews()
	{
		return news;
	}

	public void setNews(News news)
	{
		this.news = news;
	}

	public CustomerAccount getCustomer()
	{
		return customer;
	}

	public void setCustomer(CustomerAccount customer)
	{
		this.customer = customer;
	}

	public EmployeeAccount getEmployee()
	{
		return employee;
	}

	public void setEmployee(EmployeeAccount employee)
	{
		this.employee = employee;
	}

	public List<Comment> getReplies()
	{
		return replies;
	}

	public void setReplies(List<Comment> replies)
	{
		this.replies = replies;
	}

	public Comment getReply()
	{
		return reply;
	}

	public void setReply(Comment reply)
	{
		this.reply = reply;
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
