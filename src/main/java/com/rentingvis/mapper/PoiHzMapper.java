package com.rentingvis.mapper;

import com.rentingvis.po.PoiHz;
import com.rentingvis.po.PoiHzExample;
import java.util.*;
import org.apache.ibatis.annotations.Param;

public interface PoiHzMapper {
    int countByExample(PoiHzExample example);

    int deleteByExample(PoiHzExample example);

    int deleteByPrimaryKey(String id);

    int insert(PoiHz record);

    int insertSelective(PoiHz record);

    List<PoiHz> selectByExample(PoiHzExample example);

    PoiHz selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PoiHz record, @Param("example") PoiHzExample example);

    int updateByExample(@Param("record") PoiHz record, @Param("example") PoiHzExample example);

    int updateByPrimaryKeySelective(PoiHz record);

    int updateByPrimaryKey(PoiHz record);

    List<PoiHz> poiRangeQuery(@Param("co_x") Double co_x, @Param("co_y") Double co_y,
                              @Param("list") List<String> list );

}