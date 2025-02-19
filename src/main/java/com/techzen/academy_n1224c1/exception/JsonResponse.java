package com.techzen.academy_n1224c1.exception;

import com.techzen.academy_n1224c1.dto.ApiReponse;
import com.techzen.academy_n1224c1.employee.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class JsonResponse {
    public static <T> ResponseEntity<ApiReponse<T>> ok(T t) {
        return ResponseEntity.ok(ApiReponse.<T>builder()
                .data(t)
                .build());
    }

    public static <T> ResponseEntity<ApiReponse<T>> create(T t) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiReponse.<T>builder()
                        .data(t)
                        .build());
    }

    public static ResponseEntity<Employee> noContent() {
        return ResponseEntity.notFound().build();
    }
}
