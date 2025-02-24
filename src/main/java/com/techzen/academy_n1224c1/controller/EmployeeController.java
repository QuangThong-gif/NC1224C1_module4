package com.techzen.academy_n1224c1.controller;

import com.techzen.academy_n1224c1.dto.ApiReponse;
import com.techzen.academy_n1224c1.model.Employee;
import com.techzen.academy_n1224c1.exception.ApiException;
import com.techzen.academy_n1224c1.exception.ErrorCode;
import com.techzen.academy_n1224c1.service.IEmployeesService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeController {
    IEmployeesService employeesService;

    @GetMapping
    public List<Employee> listEmployee() {
        return employeesService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiReponse<Employee>> getEmployee(@PathVariable("id") int id) {
        Employee employee = employeesService.findById(id);
        if (employee == null) {
            throw new ApiException(ErrorCode.EMPLOYEE_NOT_EXITS);
        }
        return ResponseEntity.ok(ApiReponse.<Employee>builder().data(employee).build());
    }

    @PostMapping
    public ResponseEntity<ApiReponse<Employee>> addEmployee(@RequestBody Employee employee) {
        employeesService.addEmployee(employee);

        return ResponseEntity.ok(ApiReponse.<Employee>builder().data(employee).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiReponse<Employee>> updateEmployee(@RequestBody Employee employee, @PathVariable("id") int id) {
        boolean updated = employeesService.updateById(id, employee);
        if (!updated) {
            throw new ApiException(ErrorCode.EMPLOYEE_NOT_EXITS);
        }
        return ResponseEntity.ok(ApiReponse.<Employee>builder().data(employee).build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiReponse<Void>> deleteEmployee(@PathVariable("id") int id) {
        boolean deleted = employeesService.deleteById(id);
        if (!deleted) {
            throw new ApiException(ErrorCode.EMPLOYEE_NOT_EXITS);
        }
        return ResponseEntity.noContent().build();
    }
}
