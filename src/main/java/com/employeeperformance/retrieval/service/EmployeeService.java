package com.employeeperformance.retrieval.service;

import com.employeeperformance.retrieval.dto.*;
import com.employeeperformance.retrieval.model.Employee;
import com.employeeperformance.retrieval.model.PerformanceReview;
import com.employeeperformance.retrieval.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<EmployeeListDTO> filterEmployees(Integer score, LocalDate reviewDate, List<Long> departmentIds, List<Long> projectIds) {
        List<Employee> employees = employeeRepository.findFilteredEmployees(score, reviewDate, departmentIds, projectIds);

        List<EmployeeListDTO> employeeListDTO = employees.stream().map(emp -> {
            ManagerDTO manager = new ManagerDTO(emp.getManager().getId(), emp.getManager().getName(), emp.getManager().getEmail());
            return new EmployeeListDTO(emp.getId(), emp.getName(), emp.getEmail(), manager, emp.getDepartment());
        }).collect(Collectors.toList());

        return employeeListDTO;
    }

    public EmployeeDetailsDTO getEmployeeDetails(Long id) {
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));

        List<PerformanceReviewDTO> top3 = emp.getPerformanceReviews().stream()
                .sorted(Comparator.comparing(PerformanceReview::getReviewDate).reversed())
                .limit(3)
                .map(r -> new PerformanceReviewDTO(r.getReviewDate(), r.getScore(), r.getReviewComments()))
                .collect(Collectors.toList());

        List<ProjectAssignmentDTO> projectAssignments = emp.getEmployeeProjects().stream()
                .map(ep -> new ProjectAssignmentDTO(
                        ep.getProject().getId(),
                        ep.getProject().getName(),
                        ep.getAssignedDate(),
                        ep.getRole()
                ))
                .collect(Collectors.toList());

        ManagerDTO managerDTO = Optional.ofNullable(emp.getManager())
                .map(m -> new ManagerDTO(m.getId(), m.getName(), m.getEmail()))
                .orElse(null);


        return new EmployeeDetailsDTO(
                emp.getId(),
                emp.getName(),
                emp.getEmail(),
                managerDTO,
                emp.getDepartment(),
                projectAssignments,
                top3
        );
    }
}
