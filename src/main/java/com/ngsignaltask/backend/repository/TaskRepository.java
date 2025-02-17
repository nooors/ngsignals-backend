package com.ngsignaltask.backend.repository;

import com.ngsignaltask.backend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository <Task, Long> {

}
