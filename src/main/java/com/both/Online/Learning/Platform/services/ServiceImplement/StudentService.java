package com.both.Online.Learning.Platform.services.ServiceImplement;

import com.both.Online.Learning.Platform.models.entity.Course;
import com.both.Online.Learning.Platform.models.entity.Student;
import com.both.Online.Learning.Platform.models.request.StudentRequest;
import com.both.Online.Learning.Platform.models.response.APIResponseStudent;
import com.both.Online.Learning.Platform.repositories.IStudentCourse;
import com.both.Online.Learning.Platform.repositories.IStudentRepo;
import com.both.Online.Learning.Platform.services.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService implements IStudentService {

  private final IStudentRepo studentRepo;
  private final IStudentCourse studentCourse;

  public StudentService(IStudentRepo studentRepo, IStudentCourse studentCourse) {
    this.studentRepo = studentRepo;
    this.studentCourse = studentCourse;
  }

  @Override
  public ResponseEntity<APIResponseStudent<List<Student>>> getAllStudents() {

    List<Student> students = studentRepo.getAllStudents();

    APIResponseStudent<List<Student>> response = new APIResponseStudent<>("All students have been successfully fetched.", students, HttpStatus.OK, LocalDateTime.now());

    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<APIResponseStudent<Student>> createStudent(StudentRequest request) {

    Student student = studentRepo.createStudent(request);

    for (Long courseId : request.getCourseId()) {
      studentCourse.insertCourseByStudentId(student.getStudentId(), courseId);
    }

    APIResponseStudent<Student> response = new APIResponseStudent<>("The student has been successfully added.", studentRepo.getStudentById(student.getStudentId()), HttpStatus.CREATED, LocalDateTime.now());

    return ResponseEntity.ok(response);
  }


  @Override
  public ResponseEntity<APIResponseStudent<Student>> getStudentById(Long studentId) {

    Student student = studentRepo.getStudentById(studentId);

    APIResponseStudent<Student> response = new APIResponseStudent<>("The student has been successfully founded.", student, HttpStatus.OK, LocalDateTime.now());


    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<APIResponseStudent<Student>> updateStudentById(StudentRequest request, Long studentId) {

    Student student = studentRepo.updateStudentById(request, studentId);

    APIResponseStudent<Student> response = new APIResponseStudent<>("The student has been successfully updated.", student, HttpStatus.OK, LocalDateTime.now());


    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<APIResponseStudent<Student>> deleteStudentById(Long studentId) {

    Student student = studentRepo.deleteStudentById(studentId);

    APIResponseStudent<Student> response = new APIResponseStudent<>("The student has been successfully deleted.", student, HttpStatus.OK, LocalDateTime.now());

    return ResponseEntity.ok().body(response);
  }

}
