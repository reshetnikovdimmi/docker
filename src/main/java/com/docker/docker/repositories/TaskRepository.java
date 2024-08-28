package com.docker.docker.repositories;

import com.docker.docker.model.Task;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {


    List<Task> findByAuthorIdLikeOrExecutorIdLike(Long priority, Long status, Pageable pageable);
}
