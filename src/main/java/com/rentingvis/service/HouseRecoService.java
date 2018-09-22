package com.rentingvis.service;

import java.util.List;

import com.rentingvis.po.HouseTotal;

public interface HouseRecoService {
    List<HouseTotal> recoHouses(String houseName, String direction, String price, String height, String structure, String area, int defau, int transportOrder, int serviceOrder, int environmentOrder, int educationOrder, int treatmentOrder, int shopOrder, int lifeOrder, int entertainmentOrder, int financeOrder);
}
