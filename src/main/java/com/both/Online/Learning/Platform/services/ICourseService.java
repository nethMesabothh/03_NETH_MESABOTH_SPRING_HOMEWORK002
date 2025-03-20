package com.both.Online.Learning.Platform.services;

import com.both.Online.Learning.Platform.models.entity.Course;
import com.both.Online.Learning.Platform.models.entity.Instructor;
import com.both.Online.Learning.Platform.models.request.CourseRequest;
import com.both.Online.Learning.Platform.models.request.InstructorRequest;
import com.both.Online.Learning.Platform.models.response.APIResponseCourse;
import com.both.Online.Learning.Platform.models.response.APIResponseInstructor;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICourseService {

  ResponseEntity<APIResponseCourse<List<Course>>> getAllCourses(Integer page, Integer size);


  ResponseEntity<APIResponseCourse<Course>> createCourse(CourseRequest request);

  ResponseEntity<APIResponseCourse<Course>> getCourseById(Long courseId);

  ResponseEntity<APIResponseCourse<Course>> updateCourseById(CourseRequest request, Long courseId);

  ResponseEntity<APIResponseCourse<Course>> deleteCourseById(Long courseId);
}
