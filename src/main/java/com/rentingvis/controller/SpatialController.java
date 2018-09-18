package com.rentingvis.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rentingvis.po.HouseTotal;
import com.rentingvis.po.PoiHz;
import com.rentingvis.service.SpatialService;

@Controller
public class SpatialController {
    @Autowired
    private SpatialService spatialService;

    @RequestMapping(value = "/polygon", method = {RequestMethod.GET})
    @ResponseBody
    public List<HouseTotal> showHouses_Polygon (@RequestParam(value="coordinates")  Double[] coordinates ) {
        List<HouseTotal> result = spatialService.polygonQuery(coordinates);
        return result;
    }

    @RequestMapping(value = "/poi", method = {RequestMethod.GET})
    @ResponseBody
    public List<PoiHz> showPOI ( @RequestParam(value="tag_list")  Integer[] tag_list, @RequestParam(value="pHouse")  Double[] pHouse ) {
        List<PoiHz> result = spatialService.poiQuery( tag_list, pHouse );
        return result;
    }

}
