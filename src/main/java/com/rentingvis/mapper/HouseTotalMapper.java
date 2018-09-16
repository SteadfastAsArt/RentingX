package com.rentingvis.mapper;

import com.rentingvis.po.HouseTotal;
import com.rentingvis.po.HouseTotalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HouseTotalMapper {
    int countByExample(HouseTotalExample example);

    int deleteByExample(HouseTotalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HouseTotal record);

    int insertSelective(HouseTotal record);

    List<HouseTotal> selectByExample(HouseTotalExample example);

    HouseTotal selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HouseTotal record, @Param("example") HouseTotalExample example);

    int updateByExample(@Param("record") HouseTotal record, @Param("example") HouseTotalExample example);

    int updateByPrimaryKeySelective(HouseTotal record);

    int updateByPrimaryKey(HouseTotal record);

    List<HouseTotal> polygonHouseQuery(@Param("xmin") Double xmin, @Param("ymin") Double ymin, @Param("xmax") Double xmax, @Param("ymax") Double ymax);

}