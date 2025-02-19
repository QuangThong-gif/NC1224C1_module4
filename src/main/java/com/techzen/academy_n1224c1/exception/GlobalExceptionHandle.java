package com.techzen.academy_n1224c1.exception;

import com.techzen.academy_n1224c1.dto.ApiReponse;
import com.techzen.academy_n1224c1.employee.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class GlobalExceptionHandle {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handleApiException(ApiException e) {
        ErrorCode errorCode = e.getErrorCode();

//        return ResponseEntity.status(ErrorCode.STUDENT_NOT_EXITS.getHttpStatus())
//                .body(ApiReponse.<Student>builder()
//                        .code(ErrorCode.STUDENT_NOT_EXITS.getCode())
//                        .message(ErrorCode.STUDENT_NOT_EXITS.getMessage())
//                        .build());

        return ResponseEntity.status(ErrorCode.EMPLOYEE_NOT_EXITS.getHttpStatus())
                .body(ApiReponse.<Employee>builder()
                        .code(ErrorCode.EMPLOYEE_NOT_EXITS.getCode())
                        .message(ErrorCode.EMPLOYEE_NOT_EXITS.getMessage())
                        .build());
    }
}
