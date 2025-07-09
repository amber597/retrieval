package com.employeeperformance.retrieval.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class PerformanceReview {
    @Id
    private Long id;

    @ManyToOne
    private Employee employee;

    private LocalDate reviewDate;
    private Integer score;
    private String reviewComments;
}
