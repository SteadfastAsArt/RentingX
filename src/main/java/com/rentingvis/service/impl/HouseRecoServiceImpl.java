package com.rentingvis.service.impl;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentingvis.po.HouseTotal;
import com.rentingvis.po.HouseTotalExample;
import com.rentingvis.mapper.HouseTotalMapper;
import com.rentingvis.service.HouseRecoService;

@Service("houseRecoService")
public class HouseRecoServiceImpl implements HouseRecoService {
    @Autowired
    private HouseTotalMapper housesMapper;

    public final static boolean isNumeric(String s) {
        if (s != null && !"".equals(s.trim()))
            return s.matches("^[0-9]*$");
        else return false;
    }

    private double scoleLevel(int order){
        double res;
        res = 90.0 - 15 * order;
        return res;
    }

    @Override
    public List<HouseTotal> recoHouses ( String houseName, String direction, String price, String height,
                                         String structure, String area, int defau, int transportOrder, int serviceOrder,
                                         int environmentOrder, int educationOrder, int treatmentOrder, int shopOrder,
                                         int lifeOrder, int entertainmentOrder, int financeOrder ) {
        List<HouseTotal> houseList = null;

        try{
            HouseTotalExample housesExample = new HouseTotalExample();
            HouseTotalExample.Criteria housesCriteria = housesExample.createCriteria();

            if (!(houseName.equals(""))){
                housesCriteria.andCommnameLike("%"+houseName+"%");
            }

            if (!(direction.equals("全部")||direction.equals(""))){
                String directionArr[] = direction.split("\\s+");
                for (int i = 0; i < directionArr.length; i++){
                    housesCriteria.andDirectionLike("%" + directionArr[i] + "%");
                }
            }

            if (!(price.equals("全部")||price.equals(""))){
                String priceArr[] = price.split("\\s+|~");
                double priceArray[] = new double[12];
                for (int i = 0, j = 0; i < priceArr.length; i++){
                    if (isNumeric(priceArr[i])){
                        priceArray[j] = Double.parseDouble(priceArr[i]);
                        j++;
                    }
                }
                double temp;
                int index = priceArray.length;
                for (int i = 1; i < priceArray.length; i = i+2) {
                    if(priceArray[i] == 0) {
                        index = i-1;
                        break;
                    }
                }
                for (int i = 0; i < index-1; i++){
                    for (int j = i; j < index; j++){
                        if (priceArray[i] > priceArray[j]){
                            temp = priceArray[i];
                            priceArray[i] = priceArray[j];
                            priceArray[j] = temp;
                        }
                    }
                }
                for (int i = 0; i < index; i = i+2){
                    if (i == 0){
                        housesCriteria.andPriceGreaterThan(priceArray[i]);
                    }
                    if (i == index-2){
                        housesCriteria.andPriceLessThan(priceArray[i+1]);
                    }
                    if (i != 0 && i != index-2){
                        housesCriteria.andPriceNotBetween(priceArray[i-1], priceArray[i]);
                    }
                }
            }

            if (!(height.equals("全部")||height.equals(""))){
                List<String> heightList = new ArrayList<>();
                String heightArr[] = height.split("\\s+");
                for (int i = 0; i < heightArr.length; i++){
                    heightList.add(heightArr[i]);
                }
                housesCriteria.andHpartIn(heightList);
            }

            if (!(structure.equals("全部")||structure.equals(""))){
                List<String> structureList = new ArrayList<>();
                String structureArr[] = structure.split("\\s+");
                for (int i = 0; i < structureArr.length; i++){
                    structureList.add(structureArr[i]);
                }
                housesCriteria.andStructureIn(structureList);
            }

            if (!(area.equals("全部")||area.equals(""))){
                String areaArr[] = area.split("\\s+|~");
                double areaArray[] = new double[12];
                for (int i = 0, j = 0; i < areaArr.length; i++){
                    if (isNumeric(areaArr[i])){
                        areaArray[j] = Double.parseDouble(areaArr[i]);
                        j++;
                    }
                }
                double temp2;
                int index = areaArray.length;
                for (int i = 1; i < areaArray.length; i = i+2) {
                    if(areaArray[i] == 0) {
                        index = i-1;
                        break;
                    }
                }
                for (int i = 0; i < index-1; i++){
                    for (int j = i; j < index; j++){
                        if (areaArray[i] > areaArray[j]){
                            temp2 = areaArray[i];
                            areaArray[i] = areaArray[j];
                            areaArray[j] = temp2;
                        }
                    }
                }
                for (int i = 0; i < index; i = i+2){
                    if (i == 0){
                        housesCriteria.andAreaGreaterThan(areaArray[i]);
                    }
                    if (i == index-2){
                        housesCriteria.andAreaLessThan(areaArray[i+1]);
                    }
                    if (i != 0 && i != index-2){
                        housesCriteria.andAreaNotBetween(areaArray[i-1], areaArray[i]);
                    }
                }
            }

            if (defau == 2){
                housesCriteria.andTotalscoleGreaterThanOrEqualTo(70.0);
            }
            else if (defau == 3){

                housesCriteria.andTransportscoleGreaterThanOrEqualTo(scoleLevel(transportOrder));
                housesCriteria.andServicescoleGreaterThanOrEqualTo(scoleLevel(serviceOrder));
                housesCriteria.andEnvironmentscoleGreaterThanOrEqualTo(scoleLevel(environmentOrder));

                housesCriteria.andEducationscoleGreaterThanOrEqualTo(scoleLevel(educationOrder));
                housesCriteria.andTreatmentscoleGreaterThanOrEqualTo(scoleLevel(treatmentOrder));
                housesCriteria.andShopscoleGreaterThanOrEqualTo(scoleLevel(shopOrder));
                housesCriteria.andLifescoleGreaterThanOrEqualTo(scoleLevel(lifeOrder));
                housesCriteria.andEntertainmentscoleGreaterThanOrEqualTo(scoleLevel(entertainmentOrder));
                housesCriteria.andFinancescoleGreaterThanOrEqualTo(scoleLevel(financeOrder));
            }

            houseList = housesMapper.selectByExample(housesExample);
            Collections.sort(houseList, new Comparator<HouseTotal>() {
                @Override
                public int compare(HouseTotal h1, HouseTotal h2){
                    if ( h1.getTotalscole() > h2.getTotalscole() ) {
                        return -1;
                    }
                    else if ( h1.getTotalscole() < h2.getTotalscole() ) {
                        return 1;
                    }
                    else return 0;
                }
            });
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return houseList;
    }
}
