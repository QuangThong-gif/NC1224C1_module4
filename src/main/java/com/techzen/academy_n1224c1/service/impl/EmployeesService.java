package com.techzen.academy_n1224c1.service.impl;

import com.techzen.academy_n1224c1.model.Employee;
import com.techzen.academy_n1224c1.repository.impl.EmployeeReponsitory;
import com.techzen.academy_n1224c1.service.IEmployeesService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeesService implements IEmployeesService {
    EmployeeReponsitory employeeReponsitory;

    public List<Employee> findAll() {
        return employeeReponsitory.findAll();
    }

    public Employee findById(int id) {
        return employeeReponsitory.findById(id);
    }

    public void addEmployee(Employee employee) {
        employeeReponsitory.addEmployee(employee);
    }

    public boolean updateById(int id, Employee updatedEmployee) {
        return employeeReponsitory.updateById(id, updatedEmployee);
    }

    public boolean deleteById(int id) {
        return employeeReponsitory.deleteById(id);
    }
}
