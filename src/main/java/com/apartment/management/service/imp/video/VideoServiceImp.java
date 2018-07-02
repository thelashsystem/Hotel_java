package com.apartment.management.service.imp.video;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.imp.video.VideoDao;
import com.apartment.management.model.video.Video;
import com.apartment.management.service.interfaces.video.VideoService;

@Component
@Service
@Transactional
public class VideoServiceImp<T extends Video> implements
		VideoService<T, Integer>
{
	@Autowired
	private VideoDao<T> videoDao;

	@Override
	public void add(T video)
	{
		videoDao.add(video);
	}

	@Override
	public void update(T video)
	{
		videoDao.update(video);
	}

	@Override
	public void delete(T video)
	{
		videoDao.delete(video);
	}

	@Override
	public List<T> getAll()
	{
		return videoDao.getAll();
	}

	@Override
	public T getById(Integer id)
	{
		return videoDao.getById(id);
	}

}
