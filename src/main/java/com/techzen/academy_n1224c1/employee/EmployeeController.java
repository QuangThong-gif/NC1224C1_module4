package com.techzen.academy_n1224c1.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/Employees")
public class EmployeeController {
    private List<Employee> employees = new ArrayList<Employee>(
            Arrays.asList(
                    new Employee(1,"thanh", LocalDate.of(2003,11,22), Employee.Gender.Nữ,14000000),
                    new Employee(2,"linh", LocalDate.of(2003,7,4), Employee.Gender.Nữ,15000000),
                    new Employee(3,"Hai", LocalDate.of(2005,9,30), Employee.Gender.Nam,15000000)
            )

    );

    @GetMapping
    public List<Employee> listEmployee() {
        return employees;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
        for (Employee employee : employees) {
            if(employee.getId()==id) {

                return ResponseEntity.ok(employee);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        employee.setId((int) (Math.random() * 1000));
        employees.add(employee);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") int id) {
        for (Employee emp : employees) {
            if(emp.getId()==id) {
                emp.setTen(employee.getTen());
                emp.setGioitinh(employee.getGioitinh());
                emp.setNgaysinh(employee.getNgaysinh());
                emp.setLuong(employee.getLuong());
                return ResponseEntity.ok(emp);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                Employee deletedEmployee = employees.get(i);
                employees.remove(i);
                return ResponseEntity.ok(deletedEmployee);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
