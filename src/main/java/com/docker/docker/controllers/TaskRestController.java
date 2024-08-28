package com.docker.docker.controllers;

import com.docker.docker.dtos.FilterDto;
import com.docker.docker.model.Task;
import com.docker.docker.service.intrf.CRUDService;
import com.docker.docker.service.intrf.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(TaskRestController.TASK_REST_URL)
public class TaskRestController extends CRUDRestController<Task, Long> {
    @Autowired
    private TaskService taskService;
    public static final String TASK_REST_URL = "task";

    @Override
    CRUDService<Task, Long> getService() {
        return taskService;
    }

    @PostMapping("/filt")
    public List<Task> filt(@RequestBody FilterDto object) {

        return taskService.filt(object);
    }
}
