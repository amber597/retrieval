package com.employeeperformance.retrieval.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Employee {
    @Id
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;
    private LocalDate dateOfJoining;
    private Double salary;

    @ManyToOne
    private Department department;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @OneToMany(mappedBy = "employee")
    private Set<EmployeeProject> employeeProjects;

    @OneToMany(mappedBy = "employee")
    private List<PerformanceReview> performanceReviews;
}
