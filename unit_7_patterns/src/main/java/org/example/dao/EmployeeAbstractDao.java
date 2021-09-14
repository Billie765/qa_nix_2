package org.example.dao;

import org.example.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EmployeeAbstractDao {

    protected List<Employee> employeeList = new ArrayList<>();

    protected void createEmployee(Employee employee) {
        employee.setId(generateId());
        employeeList.add(employee);
    }

    protected void updateEmployee(Employee employee) {
        if (existById(employee.getId())) {
            Employee current = findEmployeeById(employee.getId());
            current.setFirstName(employee.getFirstName());
            current.setLastName(employee.getLastName());
            current.setEmail(employee.getEmail());
            current.setDepartmentId(employee.getDepartmentId());
        }
    }

    protected List<Employee> getEmployeeList () {
        return employeeList;
    }

    protected void deleteEmployee(String id) {
        employeeList.removeIf(employee -> employee.getId().equals(id));
    }

    protected Employee findEmployeeById(String id) {
        return employeeList.stream().filter(employee -> employee.getId().equals(id)).findFirst().get();
    }

    protected Employee findEmployeeByEmail(String email) {
        return employeeList.stream().filter(employee -> employee.getEmail().equals(email)).findFirst().get();
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (existById(id)) {
            return generateId();
        }
        return id;
    }

    private boolean existByEmail(String email) {
        return employeeList.stream().anyMatch(employee -> employee.getEmail().equals(email));
    }

    private boolean existById(String id) {
        return employeeList.stream().anyMatch(employee -> employee.getId().equals(id));
    }
}
