package com.both.Online.Learning.Platform.controllers;

import com.both.Online.Learning.Platform.models.entity.Student;
import com.both.Online.Learning.Platform.models.request.StudentRequest;
import com.both.Online.Learning.Platform.models.response.APIResponseStudent;
import com.both.Online.Learning.Platform.services.ServiceImplement.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }


  @GetMapping
  public ResponseEntity<APIResponseStudent<List<Student>>> getAllStudents(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
    return studentService.getAllStudents(page, size);
  }

  @PostMapping
  public ResponseEntity<APIResponseStudent<Student>> createStudent(@RequestBody StudentRequest request) {

    return studentService.createStudent(request);
  }

  @GetMapping("/{student-id}")
  public ResponseEntity<APIResponseStudent<Student>> getStudentById(@PathVariable("student-id") Long studentId) {
    return studentService.getStudentById(studentId);
  }

  @PutMapping("/{student-id}")
  public ResponseEntity<APIResponseStudent<Student>> updateStudentById(@RequestBody StudentRequest request, @PathVariable("student-id") Long studentId) {
    return studentService.updateStudentById(request, studentId);
  }

  @DeleteMapping("/{student-id}")
  public ResponseEntity<APIResponseStudent<Student>> deleteStudentById(@PathVariable("student-id") Long studentId) {
    return studentService.deleteStudentById(studentId);
  }

}
