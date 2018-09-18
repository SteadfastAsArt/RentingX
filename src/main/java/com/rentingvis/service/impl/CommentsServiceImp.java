package com.rentingvis.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentingvis.mapper.*;
import com.rentingvis.po.*;
import com.rentingvis.service.CommentsService;


@Service("commentsService")
public class CommentsServiceImp implements CommentsService {
    @Autowired
    private CommunityCommentsMapper commentsQMapper;

    @Override
    public List<CommunityComments> commentsQuery (String community_name) {
        List<CommunityComments> commentsList = null;

        try {

            CommunityCommentsExample cce = new CommunityCommentsExample();
            CommunityCommentsExample.Criteria ccc = cce.createCriteria();

            ccc.andNameLike("%" + community_name + "%");

            commentsList = commentsQMapper.selectByExample(cce);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return commentsList;
    }
}
