package com.rentingvis.service.impl;

import java.util.*;

import com.rentingvis.po.HouseTotalExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentingvis.mapper.HouseTotalMapper;
import com.rentingvis.po.HouseTotal;
import com.rentingvis.service.FindOptimalService;


@Service("findOptimalService")
public class FindOptimalServiceImp implements FindOptimalService {
    @Autowired
    private HouseTotalMapper optimalQMapper;

    @Override
    public List<HouseTotal> shortestSumDistance (Double[] picked_points ) {
        List<HouseTotal> houseList = null;
        try {
            HouseTotalExample lianjiaExample = new HouseTotalExample();
            HouseTotalExample.Criteria lianjiaCriteria = lianjiaExample.createCriteria();
            houseList = optimalQMapper.selectByExample(lianjiaExample);

            ArrayList<Point> house_point = new ArrayList<>();
            for (HouseTotal _h: houseList) {
                house_point.add(new Point(_h.getX(), _h.getY()));
            }

            FindOptimal opt = new FindOptimal();
            opt.readMap ( houseList.size(), house_point );

            ArrayList<Point> choosed = new ArrayList<>();
            for (int i = 0; i < picked_points.length; i += 2 ) {
                choosed.add(new Point(picked_points[i], picked_points[i+1]));
            }
            ArrayList<Integer> selectedHouses = opt.solveFirstK( 35, choosed);

            lianjiaCriteria.andIdIn(selectedHouses);
            houseList = optimalQMapper.selectByExample(lianjiaExample);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return houseList;
    }

}
