package org.example.dao;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.example.config.FileType;
import org.example.entity.Employee;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service("JSONEmplDao")
public class JSONEmplDao extends EmployeeAbstractDao implements EmplFileIO, EmployeeDao{

    @Override
    public void loadEmployees() {
        super.employeeList.clear();
        try {
            String employeesOut = FileUtils.readFileToString(new File(FileType.JSON_TYPE.getPath()), "UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            super.employeeList = objectMapper.readValue(employeesOut, new TypeReference<>() { });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void storeEmployees() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (json, typeOfT, context) -> new Date(json.getAsJsonPrimitive().getAsLong()))
                .registerTypeAdapter(Date.class, (JsonSerializer<Date>) (date, type, jsonSerializationContext) -> new JsonPrimitive(date.getTime()))
                .create();
        String employeesOut = gson.toJson(employeeList);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FileType.JSON_TYPE.getPath()))) {
            writer.append(employeesOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Employee employee) {
        loadEmployees();
        createEmployee(employee);
        storeEmployees();
    }

    @Override
    public void update(Employee employee) {
        loadEmployees();
        updateEmployee(employee);
        storeEmployees();
    }

    @Override
    public void delete(String id) {
        loadEmployees();
        deleteEmployee(id);
        storeEmployees();
    }

    @Override
    public Employee findById(String id) {
        loadEmployees();
        return findEmployeeById(id);
    }

    @Override
    public boolean existByEmail(String email) {
        loadEmployees();
        return existByEmail(email);
    }

    @Override
    public List<Employee> findAll() {
        loadEmployees();
        return findAll();
    }
}
