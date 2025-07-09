package com.employeeperformance.retrieval.controller;

import com.employeeperformance.retrieval.dto.EmployeeDetailsDTO;
import com.employeeperformance.retrieval.dto.EmployeeListDTO;
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
    public ResponseEntity<List<EmployeeListDTO>> getFilteredEmployees(
            @RequestParam(required = false) Integer score,
            @RequestParam(required = false) LocalDate reviewDate,
            @RequestParam(required = false) List<Long> departmentIds,
            @RequestParam(required = false) List<Long> projectIds
    ) {
        System.out.println(reviewDate);
        return ResponseEntity.ok(employeeService.filterEmployees(score, reviewDate, departmentIds, projectIds));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDetailsDTO> getEmployeeDetails(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeDetails(id));
    }
}


//Hibernate: select distinct e1_0.id,e1_0.date_of_joining,e1_0.department_id,e1_0.email,e1_0.manager_id,e1_0.name,e1_0.salary from employee e1_0 join department d1_0 on d1_0.id=e1_0.department_id join employee_project ep1_0 on e1_0.id=ep1_0.employee_id join project p1_0 on p1_0.id=ep1_0.project_id join performance_review pr1_0 on e1_0.id=pr1_0.employee_id where (? is null or pr1_0.score=?) and (? is null or pr1_0.review_date=?) and (? is null or d1_0.id in (?)) and (? is null or p1_0.name in (?))
