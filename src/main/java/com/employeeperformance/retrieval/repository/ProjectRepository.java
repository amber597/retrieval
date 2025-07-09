package com.employeeperformance.retrieval.repository;

import com.employeeperformance.retrieval.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByIdIn(List<Long> ids);
}

