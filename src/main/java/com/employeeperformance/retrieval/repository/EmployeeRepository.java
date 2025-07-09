package com.employeeperformance.retrieval.repository;

import com.employeeperformance.retrieval.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT DISTINCT e FROM Employee e " +
            "JOIN e.department d " +
            "JOIN e.employeeProjects ep " +
            "JOIN ep.project p " +
            "JOIN e.performanceReviews pr " +
            "WHERE (:score IS NULL OR pr.score = :score) " +
            "AND (cast(:reviewDate as date) IS NULL OR pr.reviewDate = :reviewDate) " +
            "AND (:departmentIds IS NULL OR d.id IN :departmentIds) " +
            "AND (:projectIds IS NULL OR p.id IN :projectIds)")
    List<Employee> findFilteredEmployees(
            @Param("score") Integer score,
            @Param("reviewDate") LocalDate reviewDate,
            @Param("departmentIds") List<Long> departmentIds,
            @Param("projectIds") List<Long> projectIds
    );
}
