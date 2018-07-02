package com.apartment.management.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apartment.management.model.asset.Equipment;
import com.apartment.management.model.business.Resource;
import com.apartment.management.response.StatusResponse;
import com.apartment.management.service.interfaces.asset.EquipmentService;

@Controller
@RequestMapping(value = "asset")
public class AssetController
{
	@Autowired
	private EquipmentService equipmentService;

	@RequestMapping(value = "asset-list", method = RequestMethod.GET)
	private String doView(Model m)
	{
		return "asset-list";
	}

	@RequestMapping(value = "asset-detail", method = RequestMethod.GET)
	private String doDetailView(Model m)
	{
		return "asset-detail";
	}

	@RequestMapping(value = "getAllEquip", method = RequestMethod.GET)
	@ResponseBody
	private List<Equipment> getAllRoomType()
	{
		List<Equipment> listEquip = equipmentService.getAll();
		return listEquip;
	}

	@RequestMapping(value = "addEquipment", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Equipment> doAdd()
	{
		return new StatusResponse<Equipment>();
	}

	@RequestMapping(value = "updateEquipment", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Equipment> doUpdate()
	{
		return new StatusResponse<Equipment>();
	}

	@RequestMapping(value = "deleteEquipment", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse doDelete()
	{
		return new StatusResponse();
	}
}
