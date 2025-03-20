package com.both.Online.Learning.Platform.services;

import com.both.Online.Learning.Platform.models.entity.Student;
import com.both.Online.Learning.Platform.models.request.StudentRequest;
import com.both.Online.Learning.Platform.models.response.APIResponseStudent;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IStudentService {
  ResponseEntity<APIResponseStudent<List<Student>>> getAllStudents();

  ResponseEntity<APIResponseStudent<Student>> createStudent(StudentRequest request);

  ResponseEntity<APIResponseStudent<Student>> getStudentById(Long studentId);

  ResponseEntity<APIResponseStudent<Student>> updateStudentById(StudentRequest request, Long studentId);

  ResponseEntity<APIResponseStudent<Student>> deleteStudentById(Long studentId);

}
