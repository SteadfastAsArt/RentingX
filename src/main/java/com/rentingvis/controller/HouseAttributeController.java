package com.rentingvis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rentingvis.po.HouseTotal;
import com.rentingvis.service.AttributeService;

@Controller
public class HouseAttributeController {
	@Autowired
	private AttributeService attributeService;
	
	@RequestMapping(value="/showHouse", method = {RequestMethod.GET})
	@ResponseBody
	public List<HouseTotal> showHouses(String commname, int priceIdx, int areaIdx, String structure, String floor, String direction) {
		List<HouseTotal> result = attributeService.attributeQueryHouse(commname, priceIdx, areaIdx, structure, floor, direction);
		return result;
	}
}
