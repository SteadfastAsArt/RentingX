package com.rentingvis.mapper;

import com.rentingvis.po.CommunityComments;
import com.rentingvis.po.CommunityCommentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommunityCommentsMapper {
    int countByExample(CommunityCommentsExample example);

    int deleteByExample(CommunityCommentsExample example);

    int insert(CommunityComments record);

    int insertSelective(CommunityComments record);

    List<CommunityComments> selectByExample(CommunityCommentsExample example);

    int updateByExampleSelective(@Param("record") CommunityComments record, @Param("example") CommunityCommentsExample example);

    int updateByExample(@Param("record") CommunityComments record, @Param("example") CommunityCommentsExample example);
}