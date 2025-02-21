package com.techzen.academy_n1224c1.repository.impl;

import com.techzen.academy_n1224c1.model.Employee;
import com.techzen.academy_n1224c1.repository.IEmployeesReponsitory;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class EmployeeReponsitory implements IEmployeesReponsitory {
    private List<Employee> employees = new ArrayList<>(Arrays.asList(

            new Employee(1, "Truyền", LocalDate.of(2003, 12, 12), Employee.Gender.MALE, 5050000),
            new Employee(2, "Thảo", LocalDate.of(2003, 7, 7), Employee.Gender.FEMALE, 5644000),
            new Employee(3, "Mai", LocalDate.of(2005, 9, 30), Employee.Gender.OTHER, 3443000)
    ));

    public List<Employee> findAll() {
        return employees;
    }

    public List<Employee> getEmployees(String name) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getTen().equalsIgnoreCase(name)) {
                result.add(employee);
            }
        }
        return result;
    }

    public Employee findById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public boolean updateById(int id, Employee updatedEmployee) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                emp.setTen(updatedEmployee.getTen());
                emp.setGioitinh(updatedEmployee.getGioitinh());
                emp.setNgaysinh(updatedEmployee.getNgaysinh());
                emp.setLuong(updatedEmployee.getLuong());
                return true;
            }
        }
        return false;
    }

    public boolean deleteById(int id) {
        return employees.removeIf(emp -> emp.getId() == id);
    }
}
