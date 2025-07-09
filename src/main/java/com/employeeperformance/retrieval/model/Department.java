package com.employeeperformance.retrieval.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Department {
    @Id
    private Long id;

    private String name;
    private Double budget;
}
