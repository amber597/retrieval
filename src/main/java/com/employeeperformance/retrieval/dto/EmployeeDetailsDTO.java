package com.employeeperformance.retrieval.dto;

import com.employeeperformance.retrieval.model.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetailsDTO {
    private Long id;
    private String name;
    private String email;
    private Department department;
    private List<ProjectAssignmentDTO> projectAssignments;
    private List<PerformanceReviewDTO> recentReviews;
}