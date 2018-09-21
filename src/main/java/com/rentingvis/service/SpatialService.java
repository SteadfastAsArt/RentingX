package com.rentingvis.service;

import java.util.List;

import com.rentingvis.po.HouseTotal;
import com.rentingvis.po.PoiHz;

public interface SpatialService {
    List<HouseTotal> polygonQuery( Double[] coordinates );
    List<PoiHz> poiQuery(  String[] tag_list, Double[] pHouse );
}
