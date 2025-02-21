package com.techzen.academy_n1224c1.service;

import com.techzen.academy_n1224c1.model.Employee;

import java.util.List;

public interface IEmployeesService {
    List<Employee> findAll();

    Employee findById(int id);

    void addEmployee(Employee employee);

    boolean updateById(int id, Employee updatedEmployee);

    boolean deleteById(int id);
}
