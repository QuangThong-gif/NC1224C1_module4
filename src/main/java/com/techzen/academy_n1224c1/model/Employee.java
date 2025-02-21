package com.techzen.academy_n1224c1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) // mặc điịnh các thuộc tính là private
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {
    private int id;
    private String ten;
    private LocalDate ngaysinh;
    private Gender gioitinh;
    private double luong;
    public enum Gender {
        MALE,
        FEMALE,
        OTHER;
    }
}
