package com.apartment.management.repository;

import javax.persistence.OrderBy;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apartment.management.model.news.CategoryNews;
import com.apartment.management.model.news.News;

public interface NewsRepository extends JpaRepository<News, Integer>
{
	@Override
	@OrderBy(value = "postedDate desc")
	public Page<News> findAll(Pageable pageable);

	public Page<News> findByCategory(CategoryNews category, Pageable pageable);
	
	@Query(value="select n from News n where DATE_FORMAT(n.postedDate, '%M %Y') = :date")
	public Page<News> findByDate(@Param(value = "date") String date, Pageable pageable);

}
