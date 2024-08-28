package com.docker.docker.controllers;

import com.docker.docker.model.Comments;
import com.docker.docker.service.intrf.CRUDService;
import com.docker.docker.service.intrf.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CommentsRestController.COMMENTS_REST_URL)
public class CommentsRestController extends CRUDRestController<Comments, Long>{

    @Autowired
    private CommentsService commentsService;
    public static final String COMMENTS_REST_URL = "comments";

    @Override
    CRUDService<Comments, Long> getService() {
        return commentsService;
    }
}
