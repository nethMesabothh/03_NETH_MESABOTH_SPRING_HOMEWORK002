package com.both.Online.Learning.Platform.services.ServiceImplement;

import com.both.Online.Learning.Platform.models.entity.Course;
import com.both.Online.Learning.Platform.models.entity.Instructor;
import com.both.Online.Learning.Platform.models.request.CourseRequest;
import com.both.Online.Learning.Platform.models.response.APIResponseCourse;
import com.both.Online.Learning.Platform.models.response.APIResponseInstructor;
import com.both.Online.Learning.Platform.repositories.ICourseRepo;
import com.both.Online.Learning.Platform.services.ICourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CourseService implements ICourseService {

  private final ICourseRepo courseRepo;

  public CourseService(ICourseRepo courseRepo) {
    this.courseRepo = courseRepo;
  }


  @Override
  public ResponseEntity<APIResponseCourse<List<Course>>> getAllCourses(Integer page, Integer size) {

    int offset = (page - 1) * size;

    List<Course> courses = courseRepo.getAllCourses(offset, size);

    APIResponseCourse<List<Course>> response = new APIResponseCourse<>("All courses have been successfully fetched.", courses, HttpStatus.OK, LocalDateTime.now());

    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<APIResponseCourse<Course>> createCourse(CourseRequest request) {
    Course course = courseRepo.createCourse(request);

    APIResponseCourse<Course> response = new APIResponseCourse<>("All courses have been successfully created.", course, HttpStatus.CREATED, LocalDateTime.now());

    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<APIResponseCourse<Course>> getCourseById(Long courseId) {
    Course course = courseRepo.getCourseById(courseId);

    APIResponseCourse<Course> response = new APIResponseCourse<>("All courses have been successfully founded.", course, HttpStatus.OK, LocalDateTime.now());

    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<APIResponseCourse<Course>> updateCourseById(CourseRequest request, Long courseId) {
    Course course = courseRepo.updateCourseById(request, courseId);

    APIResponseCourse<Course> response = new APIResponseCourse<>("All courses have been successfully updated.", course, HttpStatus.OK, LocalDateTime.now());

    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<APIResponseCourse<Course>> deleteCourseById(Long courseId) {
    Course course = courseRepo.deleteCourseById(courseId);

    APIResponseCourse<Course> response = new APIResponseCourse<>("All courses have been successfully deleted.", course, HttpStatus.OK, LocalDateTime.now());

    return ResponseEntity.ok().body(response);
  }
}
