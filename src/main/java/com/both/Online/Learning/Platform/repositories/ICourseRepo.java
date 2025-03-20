package com.both.Online.Learning.Platform.repositories;

import com.both.Online.Learning.Platform.models.entity.Course;
import com.both.Online.Learning.Platform.models.entity.Instructor;
import com.both.Online.Learning.Platform.models.request.CourseRequest;
import com.both.Online.Learning.Platform.models.request.InstructorRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ICourseRepo {

  @Results(id = "courseMapper", value = {@Result(property = "courseId", column = "course_id"), @Result(property = "courseName", column = "course_name"), @Result(property = "description", column = "description"), @Result(property = "instructor", column = "instructor_id", one = @One(select = "com.both.Online.Learning.Platform.repositories.IInstructorRepo.getInstructorById"))})
  @Select("""
          SELECT * FROM courses;
          """)
  List<Course> getAllCourses();


  @ResultMap("courseMapper")
  @Select("""
          INSERT INTO courses VALUES (default, #{req.courseName}, #{req.description}, #{req.instructorId}) RETURNING *;
          """)
  Course createCourse(@Param("req") CourseRequest request);

  @ResultMap("courseMapper")
  @Select("""
          SELECT * FROM courses WHERE course_id=#{courseId}
          """)
  Course getCourseById(Long courseId);

  @ResultMap("courseMapper")
  @Select("""
          UPDATE courses SET course_name = #{req.courseName}, description = #{req.description}, instructor_id = #{req.instructorId} WHERE course_id = #{courseId} RETURNING *;
          """)
  Course updateCourseById(@Param("req") CourseRequest request, Long courseId);

  @ResultMap("courseMapper")
  @Select("""
          DELETE FROM courses WHERE course_id = #{courseId} RETURNING *;
          """)
  Course deleteCourseById(Long courseId);
}
