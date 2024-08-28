package com.docker.docker.service.impl;

import com.docker.docker.dtos.FilterDto;
import com.docker.docker.model.Task;
import com.docker.docker.model.User;
import com.docker.docker.repositories.TaskRepository;
import com.docker.docker.service.intrf.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl extends AbstractCRUDService<Task, Long>  implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    CrudRepository<Task, Long> getRepository() {
        return taskRepository;
    }

    @Override
    public void create(Task object) {
        object.setId(currentUser().getId());
        getRepository().save(object);
    }

    @Override
    public Task update(Task object) {
        if(object.getAuthorId().equals(currentUser().getId()))
            getRepository().save(object);
        return object;
    }

    @Override
    public List<Task> filt(FilterDto obj) {
        Pageable pageable = PageRequest.of(Math.toIntExact(obj.getPageNumber()), 3);
        List<Task> tasks = taskRepository.findByAuthorIdLikeOrExecutorIdLike(obj.getAuthorId(), obj.getExecutorId(),pageable);
        return  tasks;
    }

    private User currentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }


}
