package com.both.Online.Learning.Platform.controllers;

import com.both.Online.Learning.Platform.models.entity.Course;
import com.both.Online.Learning.Platform.models.entity.Instructor;
import com.both.Online.Learning.Platform.models.request.CourseRequest;
import com.both.Online.Learning.Platform.models.request.InstructorRequest;
import com.both.Online.Learning.Platform.models.response.APIResponseCourse;
import com.both.Online.Learning.Platform.models.response.APIResponseInstructor;
import com.both.Online.Learning.Platform.services.ServiceImplement.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

  private final CourseService courseService;


  public CourseController(CourseService courseService) {
    this.courseService = courseService;
  }

  @GetMapping
  public ResponseEntity<APIResponseCourse<List<Course>>> getAllCourses() {
    return courseService.getAllCourses();
  }

  @PostMapping
  public ResponseEntity<APIResponseCourse<Course>> createCourse(@RequestBody CourseRequest request) {
    return courseService.createCourse(request);
  }

  @GetMapping("/{course-id}")
  public ResponseEntity<APIResponseCourse<Course>> getCourseById(@PathVariable("course-id") Long courseId) {
    return courseService.getCourseById(courseId);
  }

  @PutMapping("/{course-id}")
  public ResponseEntity<APIResponseCourse<Course>> updateCourseById(@RequestBody CourseRequest request, @PathVariable("course-id") Long courseId) {
    return courseService.updateCourseById(request, courseId);
  }

  @DeleteMapping("/{course-id}")
  public ResponseEntity<APIResponseCourse<Course>> deleteCourseById(@PathVariable("course-id") Long courseId) {
    return courseService.deleteCourseById(courseId);
  }


  }
