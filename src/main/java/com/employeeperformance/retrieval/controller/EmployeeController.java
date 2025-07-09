package com.employeeperformance.retrieval.controller;

import com.employeeperformance.retrieval.dto.EmployeeDetailsDTO;
import com.employeeperformance.retrieval.model.Employee;
import com.employeeperformance.retrieval.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getFilteredEmployees(
            @RequestParam(required = false) Integer score,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reviewDate,
            @RequestParam(required = false) List<Long> departmentIds,
            @RequestParam(required = false) List<Long> projectIds
    ) {
        return ResponseEntity.ok(employeeService.filterEmployees(score, reviewDate, departmentIds, projectIds));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDetailsDTO> getEmployeeDetails(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeDetails(id));
    }
}
