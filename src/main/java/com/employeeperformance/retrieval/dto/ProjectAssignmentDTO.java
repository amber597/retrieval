package com.employeeperformance.retrieval.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectAssignmentDTO {
    private Long id;
    private String name;
    private LocalDate assignedDate;
    private String role;
}
