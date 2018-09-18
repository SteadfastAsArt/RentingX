package com.rentingvis.service;

import java.util.*;

import com.rentingvis.po.*;

public interface CommentsService {
    List<CommunityComments> commentsQuery (String community_name);
}
