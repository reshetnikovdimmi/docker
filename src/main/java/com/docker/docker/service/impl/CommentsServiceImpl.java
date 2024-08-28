package com.docker.docker.service.impl;

import com.docker.docker.model.Comments;
import com.docker.docker.model.User;
import com.docker.docker.repositories.CommentsRepository;
import com.docker.docker.service.intrf.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CommentsServiceImpl extends AbstractCRUDService<Comments, Long>  implements CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    CrudRepository<Comments, Long> getRepository() {
        return commentsRepository;
    }

    @Override
    public Comments update(Comments object) {
        if(object.getAuthorId().equals(currentUser().getId()))
            getRepository().save(object);
        return object;
    }

    private User currentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
