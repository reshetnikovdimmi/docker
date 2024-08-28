package com.docker.docker.service.intrf;

import com.docker.docker.dtos.FilterDto;
import com.docker.docker.model.Task;

import java.util.List;

public interface TaskService extends CRUDService<Task, Long>{
    List<Task> filt (FilterDto obj);
}
