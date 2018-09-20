package com.rentingvis.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rentingvis.po.*;
import com.rentingvis.service.FindOptimalService;


@Controller
public class FindOptimalController {
    @Autowired
    private FindOptimalService findOptimalService;

    @RequestMapping(value ="/findoptimal", method = {RequestMethod.GET})
    @ResponseBody
    public List<HouseTotal> showCustomized ( @RequestParam(value="picked_points") Double[] picked_points, @RequestParam(value="firstk") Integer firstk ) {
        List<HouseTotal> result = findOptimalService.shortestSumDistance( picked_points, firstk );
        return result;
    }
}
