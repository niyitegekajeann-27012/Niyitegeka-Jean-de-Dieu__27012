package com.restapi.controller.student;

import com.restapi.model.student.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private List<Student> students = new ArrayList<>();
    private Long nextId = 6L;

    public StudentController() {
        students.add(new Student(1L, "Uwase", "Aline", "uwase.aline@ur.ac.rw", "Computer Science", 3.8));
        students.add(new Student(2L, "Mugabo", "Eric", "mugabo.eric@ur.ac.rw", "Computer Science", 3.9));
        students.add(new Student(3L, "Ishimwe", "Grace", "ishimwe.grace@ur.ac.rw", "Business", 3.2));
        students.add(new Student(4L, "Niyonzima", "Patrick", "niyonzima.patrick@ur.ac.rw", "Engineering", 3.6));
        students.add(new Student(5L, "Umutoni", "Divine", "umutoni.divine@ur.ac.rw", "Computer Science", 3.5));
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
        return students.stream()
                .filter(s -> s.getStudentId().equals(studentId))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/major/{major}")
    public ResponseEntity<List<Student>> getStudentsByMajor(@PathVariable String major) {
        List<Student> result = students.stream()
                .filter(s -> s.getMajor().equalsIgnoreCase(major))
                .toList();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Student>> filterByGpa(@RequestParam Double gpa) {
        List<Student> result = students.stream()
                .filter(s -> s.getGpa() >= gpa)
                .toList();
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Student> registerStudent(@RequestBody Student student) {
        student.setStudentId(nextId++);
        students.add(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long studentId, @RequestBody Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(studentId)) {
                updatedStudent.setStudentId(studentId);
                students.set(i, updatedStudent);
                return ResponseEntity.ok(updatedStudent);
            }
        }
        return ResponseEntity.notFound().build();
    }
}
