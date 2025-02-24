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
    private String name;
    private LocalDate date;
    private Gender gender;
    private double salary;
    public enum Gender {
        MALE,
        FEMALE,
        OTHER;
    }
}
