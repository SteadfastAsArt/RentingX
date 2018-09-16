package com.rentingvis.service;

import java.util.List;

import com.rentingvis.po.HouseTotal;

public interface AttributeService {
	
	List<HouseTotal> attributeQueryHouse(String commname, int priceIdx, int areaIdx, String structure, String floor, String direction);
	
}
