package com.rentingvis.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentingvis.mapper.*;
import com.rentingvis.po.*;
import com.rentingvis.service.SpatialService;


@Service("spatialService")
public class SpatialServiceImp implements SpatialService{
    @Autowired
    private HouseTotalMapper spatialQMapper;

    @Autowired
    private PoiHzMapper poiHzMapper;

    @Override
    public List<HouseTotal> polygonQuery( Double[] coordinates ) {
        List<HouseTotal> houseList = null;

        try {
            houseList = spatialQMapper.polygonHouseQuery(
                    coordinates[0], coordinates[1], coordinates[2], coordinates[3]
            );
        } catch ( Exception e ) {
            System.out.println(e.getMessage());
        }

        return houseList;
    }

    @Override
    public List<PoiHz> poiQuery( Integer[] tag_list, Double[] pHouse ) {
        List<PoiHz> poiList = null;

        try {
            Map<Integer, String> tag_map = new HashMap<Integer, String>();
            tag_map.put(1, "购物");
            tag_map.put(2, "美食");
            tag_map.put(3, "娱乐");
            tag_map.put(4, "生活服务");
            tag_map.put(5, "公司");
            tag_map.put(6, "教育");
            tag_map.put(7, "金融");

            PoiHzExample poiHzExample = new PoiHzExample();
            PoiHzExample.Criteria poiCriteria = poiHzExample.createCriteria();

            for(int x : tag_list){
                poiCriteria.andStdTagLike("%" + tag_map.get(x) + "%");
            }

            poiList = poiHzMapper.poiRangeQuery(pHouse[0], pHouse[1]);

        } catch ( Exception e ) {
            System.out.println(e.getMessage());
        }

        return poiList;
    }

}