package com.techzen.academy_n1224c1;

import com.techzen.academy_n1224c1.dto.ApiReponse;
import com.techzen.academy_n1224c1.exception.ApiException;
import com.techzen.academy_n1224c1.exception.ErrorCode;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {
    @RequestMapping("/hello") //API, endpoint // https://localhost:8080/hello
    //http://localhost:8080/hello?name=Nguyen%20Van%20A&address=Da%20Nang
    public String greeting(@RequestParam(defaultValue = "Moc") String name,
                           @RequestParam(defaultValue = "Da Nang")String address) {
        return "Hello World " + name + " - " + address;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Student {
        private int id;
        private String name;
        private double score;
    }

    @RestController
    @RequestMapping("/students")
    public static class StudentController {
        private List<Student> students = new ArrayList<>(
                Arrays.asList(
                        new Student(1,"Mốc", 6.5),
                        new Student(2, "Hoàng", 3.5),
                        new Student(3, "Hông", 9.9)
                )
        );

        // Get all students or search by name
        @GetMapping
        public ResponseEntity<ApiReponse<List<Student>>> getStudents(@RequestParam(defaultValue = "") String name) {
            List<Student> studentsSearch = new ArrayList<>();
            for (Student student : students) {
                if (student.getName().contains(name)) {
                    studentsSearch.add(student);
                }
            }
            return ResponseEntity.ok(ApiReponse.<List<Student>>builder()
                    .data(studentsSearch)
                    .build());
        }

        // Get student by ID
        @GetMapping("/{id}")
        public ResponseEntity<ApiReponse<Student>> getById(@PathVariable("id") int id) {
            for (Student stud : students) {
                if (stud.getId() == id) {
                    return ResponseEntity.ok(ApiReponse.<Student>builder()
                            .data(stud)
                            .build());
                }
            }
            throw new ApiException(ErrorCode.STUDENT_NOT_EXITS);
    //        return ResponseEntity.status(ErrorCode.STUDENT_NOT_EXITS.getHttpStatus())
    //                .body(ApiReponse.<Student>builder()
    //                        .code(ErrorCode.STUDENT_NOT_EXITS.getCode())
    //                        .message(ErrorCode.STUDENT_NOT_EXITS.getMessage())
    //                        .build());
        }

        // Save new student
        @PostMapping
        public ResponseEntity<ApiReponse<Student>> save(@RequestBody Student student) {
            student.setId((int) (Math.random() * 1000000));
            students.add(student);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(ApiReponse.<Student>builder()
                            .data(student)
                            .build());
        }

        // Update student by ID
        @PutMapping("/{id}")
        public ResponseEntity<ApiReponse<Student>> update(@PathVariable int id, @RequestBody Student student) {
            for (Student stud : students) {
                if (stud.getId() == id) {
                    stud.setName(student.getName());
                    stud.setScore(student.getScore());
                    return ResponseEntity.ok(ApiReponse.<Student>builder()
                            .data(stud)
                            .build());
                }
            }
            return ResponseEntity.status(ErrorCode.STUDENT_NOT_EXITS.getHttpStatus())
                    .body(ApiReponse.<Student>builder()
                            .code(ErrorCode.STUDENT_NOT_EXITS.getCode())
                            .message(ErrorCode.STUDENT_NOT_EXITS.getMessage())
                            .build());
        }

        // Delete student by ID
        @DeleteMapping("/{id}")
        public ResponseEntity<ApiReponse<Student>> delete(@PathVariable int id) {
            boolean removed = students.removeIf(student -> student.getId() == id);
            if (removed) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.status(ErrorCode.STUDENT_NOT_EXITS.getHttpStatus())
                    .body(ApiReponse.<Student>builder()
                            .code(ErrorCode.STUDENT_NOT_EXITS.getCode())
                            .message(ErrorCode.STUDENT_NOT_EXITS.getMessage())
                            .build());
        }
    }
}


