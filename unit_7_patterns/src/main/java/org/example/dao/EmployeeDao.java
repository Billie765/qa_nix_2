package org.example.dao;

import org.example.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    void create(Employee employee);
    void update(Employee employee);
    void delete(String id);
    Employee findById(String id);
    boolean existByEmail(String email);
    List<Employee> findAll();
}
