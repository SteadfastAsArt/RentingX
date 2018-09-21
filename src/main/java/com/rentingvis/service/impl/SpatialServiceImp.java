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
    public List<PoiHz> poiQuery( String[] tag_list, Double[] pHouse ) {
        List<PoiHz> poiList = null;
        List<String> tagL = new ArrayList<>();

        try {

            for(String _s : tag_list) {
                tagL.add('%' + _s + '%');
            }

            poiList = poiHzMapper.poiRangeQuery(pHouse[0], pHouse[1], tagL);

        } catch ( Exception e ) {
            System.out.println(e.getMessage());
        }

        return poiList;
    }

}