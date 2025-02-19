package com.techzen.academy_n1224c1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1,"Mốc", 6.5),
                    new Student(2, "Hoàng", 3.5),
                    new Student(3, "Hông", 9.9)
            )
    );

    //@RequestMapping(value = "/students", method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<Student>> getStudents(@RequestParam(defaultValue = "") String name) {
        List<Student> studentsSearch = new ArrayList<>();

        for (Student student : students) {
            if (student.getName().contains(name)) {
                studentsSearch.add(student);
            }
        }
        //return ResponseEntity.status(200).body(studentsSearch);
        return ResponseEntity.ok(studentsSearch);
    }

    //@RequestMapping(value = "/students", method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student) {
        student.setId((int) (Math.random() * 1000000));
        students.add(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable int id,
                                          @RequestBody Student student) {
        for (Student stud : students) {
            if (stud.getId() == id) {
                stud.setName(student.getName());
                stud.setScore(student.getScore());
                return ResponseEntity.ok(stud);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        boolean removed = students.removeIf(student -> student.getId() == id);
        if (removed) {
            return ResponseEntity.noContent().build(); // 204 No Content khi xóa thành công
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
