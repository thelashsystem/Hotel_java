package com.apartment.management.service.imp.setting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.imp.setting.SettingDao;
import com.apartment.management.model.setting.Setting;
import com.apartment.management.service.interfaces.setting.SettingService;

@Component
@Service
@Transactional
public class SettingServiceImp implements SettingService
{
	@Autowired
	private SettingDao settingDao;

	@Override
	public void add(Setting setting)
	{
		settingDao.add(setting);
	}

	@Override
	public void update(Setting setting)
	{
		settingDao.update(setting);
	}

	@Override
	public void delete(Setting setting)
	{
		settingDao.delete(setting);
	}

	@Override
	public List<Setting> getAll()
	{
		return settingDao.getAll();
	}

	@Override
	public Setting getById(Short id)
	{
		return settingDao.getById(id);
	}

}
