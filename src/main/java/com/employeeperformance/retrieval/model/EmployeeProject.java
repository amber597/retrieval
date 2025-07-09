package com.employeeperformance.retrieval.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
class EmployeeProjectId implements Serializable {
    private Long employeeId;
    private Long projectId;
}


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeProject {

    @EmbeddedId
    private EmployeeProjectId id;

    @ManyToOne
    @MapsId("employeeId")
    @JsonIgnore
    private Employee employee;

    @ManyToOne
    @MapsId("projectId")
    private Project project;

    private LocalDate assignedDate;
    private String role;
}
