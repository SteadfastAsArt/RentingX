package com.rentingvis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentingvis.mapper.*;
import com.rentingvis.po.*;
import com.rentingvis.service.AttributeService;

@Service("attributeService")
public class AttributeServiceImp implements AttributeService{
	@Autowired
	private HouseTotalMapper attributeQMapper;
	
	@Override
	public List<HouseTotal> attributeQueryHouse(String commname, int priceIdx, int areaIdx, String structure, String floor, String direction){
		List<HouseTotal> houseList = null;
		
		try{
			HouseTotalExample lianjiaExample = new HouseTotalExample();
			HouseTotalExample.Criteria lianjiaCriteria = lianjiaExample.createCriteria();
			
			
			if(commname != ""){
				lianjiaCriteria.andCommnameLike("%"+commname+"%");
			}
			
			if(priceIdx != 0){
				if(priceIdx == 2){
					lianjiaCriteria.andPriceBetween((double)2000, (double)4000);
				}
				else if(priceIdx == 3){
					lianjiaCriteria.andPriceBetween((double)4000, (double)6000);
				}
				else if(priceIdx == 4){
					lianjiaCriteria.andPriceGreaterThan((double)6000);
				}
				else if(priceIdx == 1){
					lianjiaCriteria.andPriceLessThanOrEqualTo((double)2000);
				}
			}
			
			if(areaIdx != 0){
				if(areaIdx == 2){
					lianjiaCriteria.andAreaBetween((double)40, (double)60);
				}
				else if(areaIdx == 3){
					lianjiaCriteria.andAreaBetween((double)60, (double)80);
				}
				else if(areaIdx == 4){
					lianjiaCriteria.andAreaGreaterThan((double)80);
				}
				else if(areaIdx == 1){
					lianjiaCriteria.andAreaLessThanOrEqualTo((double)40);
				}
			}
			
			if(structure != ""){
				lianjiaCriteria.andStructureEqualTo(structure);
			}

			if(floor != ""){
				
			}
			
			if(direction != ""){
				
			}
			
			houseList = attributeQMapper.selectByExample(lianjiaExample);
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		return houseList;
	}
	
	
}
