package com.techzen.academy_n1224c1.exception;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorCode {
    STUDENT_NOT_EXITS(40401,"Student is not exist", HttpStatus.NOT_FOUND),
    TEACHER_NOT_EXITS(40401,"Teacher is not exist", HttpStatus.NOT_FOUND),
    EMPLOYEE_NOT_EXITS(40401,"Employee is not exist", HttpStatus.NOT_FOUND);
    int code;
    String message;
    HttpStatus httpStatus;
}
