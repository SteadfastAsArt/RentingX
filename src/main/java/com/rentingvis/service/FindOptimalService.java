package com.rentingvis.service;

import java.util.List;

import com.rentingvis.po.HouseTotal;

public interface FindOptimalService {
    List<HouseTotal> shortestSumDistance ( Double[] picked_points, Integer firstk );
}
