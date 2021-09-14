package org.example.dto;

import org.example.entity.Employee;

public class EmployeeResponseDto {

    private String id;
    private String firstName;
    private String lastName;
    private String departmentId;
    private String email;

    public EmployeeResponseDto(Employee employee) {
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.departmentId = employee.getDepartmentId();
        this.email = employee.getEmail();
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getEmail() {
        return email;
    }
}
