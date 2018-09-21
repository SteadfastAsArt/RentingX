package com.rentingvis.controller;

import java.util.List;

import com.rentingvis.po.HouseTotal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

import com.rentingvis.service.HouseRecoService;

@Controller
public class HouseRecoController {
    @Autowired
    private HouseRecoService houseRecoService;

    @RequestMapping ( value="/showReco", method = { RequestMethod.GET } )
    @ResponseBody
    public List<HouseTotal> recoHouses(String direction, String price, String height, String structure, String area, int defau, int transportOrder, int serviceOrder, int environmentOrder, int educationOrder, int treatmentOrder, int shopOrder, int lifeOrder, int entertainmentOrder, int financeOrder) {
        List<HouseTotal> result = houseRecoService.recoHouses(direction, price, height, structure, area, defau, transportOrder, serviceOrder, environmentOrder, educationOrder, treatmentOrder, shopOrder, lifeOrder, entertainmentOrder, financeOrder);
        return result;
    }

}
