package com.apartment.management.service.imp.image;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.imp.image.GalleryDao;
import com.apartment.management.model.image.Gallery;
import com.apartment.management.service.interfaces.image.GalleryService;

@Component
@Service
@Transactional
public class GalleryServiceImp<T extends Gallery> implements GalleryService<T>
{
	@Autowired
	private GalleryDao<T> galleryDao;

	@Override
	public void add(T gallery)
	{
		galleryDao.add(gallery);
	}

	@Override
	public void update(T gallery)
	{
		galleryDao.update(gallery);
	}

	@Override
	public void delete(T gallery)
	{
		galleryDao.delete(gallery);
	}

	@Override
	public List<T> getAll()
	{
		return galleryDao.getAll();
	}

	@Override
	public T getById(Integer id)
	{
		return galleryDao.getById(id);
	}

}
