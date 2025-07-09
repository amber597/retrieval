package com.employeeperformance.retrieval.dto;

import com.employeeperformance.retrieval.model.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeListDTO {
    private Long id;
    private String name;
    private String email;
    private ManagerDTO manager;
    private Department department;
}
