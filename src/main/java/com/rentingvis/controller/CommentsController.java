package com.rentingvis.controller;


import java.util.*;

import com.rentingvis.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rentingvis.po.*;
import com.rentingvis.service.CommentsService;

@Controller
public class CommentsController {
    @Autowired
    private CommentsService commentsService;

    @RequestMapping(value="/", method = {RequestMethod.GET})
    @ResponseBody
    public List<CommunityComments> 
}
