package com.employeeperformance.retrieval.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Employee employee;

    private LocalDate reviewDate;
    private Integer score;
    private String reviewComments;
}
