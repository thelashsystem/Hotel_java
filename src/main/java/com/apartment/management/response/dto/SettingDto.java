package com.apartment.management.response.dto;

import java.util.ArrayList;
import java.util.List;

import com.apartment.management.model.setting.Setting;

public class SettingDto
{
	private Integer id;

	public SettingDto()
	{
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public static SettingDto map(Setting setting)
	{
		SettingDto settingDto = new SettingDto();

		return settingDto;
	}

	public static List<SettingDto> map(List<Setting> listSetting)
	{
		List<SettingDto> listSettingDto = new ArrayList<>();
		for ( Setting setting : listSetting )
		{
			listSettingDto.add(map(setting));
		}
		return listSettingDto;
	}
}
