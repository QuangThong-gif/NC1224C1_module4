package com.techzen.academy_n1224c1.employee;

import com.techzen.academy_n1224c1.dto.ApiReponse;
import com.techzen.academy_n1224c1.exception.ApiException;
import com.techzen.academy_n1224c1.exception.ErrorCode;
import com.techzen.academy_n1224c1.exception.JsonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/Employees")
public class EmployeeController {
    private List<Employee> employees = new ArrayList<>(
            Arrays.asList(
                    new Employee(1, "Truyền", LocalDate.of(2003, 12, 12), Employee.Gender.Nữ, 5050000),
                    new Employee(2, "Thảo", LocalDate.of(2003, 7, 7), Employee.Gender.Nữ, 5644000),
                    new Employee(3, "Mai", LocalDate.of(2005, 9, 30), Employee.Gender.Nam, 3443000)
            )
    );

    private AtomicInteger idCounter = new AtomicInteger(4);

    @GetMapping
    public List<Employee> listEmployee() {
        return employees;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiReponse<Employee>> getEmployee(@PathVariable("id") int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return JsonResponse.ok(employee);
//                return ResponseEntity.ok(ApiReponse.<Employee>builder()
//                        .data(employee)
//                        .build());
            }
        }
        throw new ApiException(ErrorCode.EMPLOYEE_NOT_EXITS);
//        return ResponseEntity.status(ErrorCode.EMPLOYEE_NOT_EXITS.getHttpStatus())
//                .body(ApiReponse.<Employee>builder()
//                        .code(ErrorCode.EMPLOYEE_NOT_EXITS.getCode())
//                        .message(ErrorCode.EMPLOYEE_NOT_EXITS.getMessage())
//                        .build());
    }

    @PostMapping
    public ResponseEntity<ApiReponse<Employee>> addEmployee(@RequestBody Employee employee) {
        employee.setId(idCounter.getAndIncrement());
        employees.add(employee);

        return JsonResponse.create(employee);
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(ApiReponse.<Employee>builder()
//                        .data(employee)
//                        .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiReponse<Employee>> updateEmployee(@RequestBody Employee employee, @PathVariable("id") int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                emp.setTen(employee.getTen());
                emp.setGioitinh(employee.getGioitinh());
                emp.setNgaysinh(employee.getNgaysinh());
                emp.setLuong(employee.getLuong());
                return JsonResponse.ok(employee);
//                return ResponseEntity.ok(ApiReponse.<Employee>builder()
//                        .data(emp)
//                        .build());
            }
        }
        throw new ApiException(ErrorCode.EMPLOYEE_NOT_EXITS);
//        return ResponseEntity.status(ErrorCode.EMPLOYEE_NOT_EXITS.getHttpStatus())
//                .body(ApiReponse.<Employee>builder()
//                        .code(ErrorCode.EMPLOYEE_NOT_EXITS.getCode())
//                        .message(ErrorCode.EMPLOYEE_NOT_EXITS.getMessage())
//                        .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiReponse<Employee>> deleteEmployee(@PathVariable("id") int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                Employee deletedEmployee = employees.get(i);
                employees.remove(i);

                return ResponseEntity.notFound().build();
            }
        }
        throw new ApiException(ErrorCode.EMPLOYEE_NOT_EXITS);
//        return ResponseEntity.status(ErrorCode.EMPLOYEE_NOT_EXITS.getHttpStatus())
//                .body(ApiReponse.<Employee>builder()
//                        .code(ErrorCode.EMPLOYEE_NOT_EXITS.getCode())
//                        .message(ErrorCode.EMPLOYEE_NOT_EXITS.getMessage())
//                        .build());
    }
}
