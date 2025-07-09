package com.employeeperformance.retrieval.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PerformanceReviewDTO {
    private LocalDate date;
    private Integer score;
    private String comment;
}
