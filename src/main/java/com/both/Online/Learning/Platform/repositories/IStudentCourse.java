package com.both.Online.Learning.Platform.repositories;

import com.both.Online.Learning.Platform.models.entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IStudentCourse {


  @Results(id = "courseMapper", value = {
          @Result(property = "courseId", column = "course_id"),
          @Result(property = "courseName", column = "course_name"),
          @Result(property = "description", column = "description"),
          @Result(property = "instructor.instructorId", column = "instructor_id"),
          @Result(property = "instructor.instructorName", column = "instructor_name"),
          @Result(property = "instructor.email", column = "email")
  })
  @Select("""
          SELECT * FROM student_course sc INNER JOIN courses c ON sc.course_id = c.course_id LEFT JOIN instructors i ON i.instructor_id = c.instructor_id  WHERE student_id = #{studentId}
          """)
  List<Course> getAllCoursesByStudentId(Long studentId);


  @Insert("""
          INSERT INTO student_course VALUES (#{studentId}, #{courseId})
          """)
  void insertCourseByStudentId(Long studentId, Long courseId);

  @Delete("""
          DELETE FROM student_course WHERE student_id = #{studentId}
          """)
  void deleteCourseIdByStudentId(Long studentId);
}
