
### Prerequisites

- Java 21
- Maven
- PostgreSQL (or Docker for containerized DB)

Database Setup
psql -U <username> -d postgres -f src/main/resources/employee_performance.sql

db username and passwerd are user and password

## Running the Application
./mvnw spring-boot:run


 Employee Performance Management API

This is a simple Spring Boot application that exposes REST APIs for managing employees, departments, projects, performance reviews, and project assignments.

## Features

- Filter employees by performance score, review date, department, and project.
- View employee details including manager, department, reviews, and projects.
- Designed with JPA and PostgreSQL.
- Follows RESTful API design.

---

## APIS

GET /api/employees?score=4&reviewDate=2024-12-15&departmentIds=1,2&projectIds=101,102
GET /api/employees/{id}

