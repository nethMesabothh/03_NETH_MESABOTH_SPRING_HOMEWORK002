package com.both.Online.Learning.Platform.repositories;

import com.both.Online.Learning.Platform.models.entity.Student;
import com.both.Online.Learning.Platform.models.request.StudentRequest;
import com.both.Online.Learning.Platform.models.response.APIResponseStudent;
import org.apache.ibatis.annotations.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Mapper
public interface IStudentRepo {

  @Results(id = "studentMapper", value = {
          @Result(property = "studentId", column = "student_id"),
          @Result(property = "studentName", column = "student_name"),
          @Result(property = "email", column = "email"),
          @Result(property = "phoneNumber", column = "phone_number"),
          @Result(property = "courses", column = "student_id", many = @Many(select = "com.both.Online.Learning.Platform.repositories.IStudentCourse.getAllCoursesByStudentId"))
  })
  @Select("""
          SELECT * FROM students OFFSET #{offset} LIMIT #{size};
          """)
  List<Student> getAllStudents(int offset, Integer size);

  @ResultMap("studentMapper")
  @Select("""
          INSERT INTO students VALUES (default, #{req.studentName}, #{req.email}, #{req.phoneNumber}) RETURNING *;
          """)
  Student createStudent(@Param("req") StudentRequest request);


  @ResultMap("studentMapper")
  @Select("""
          SELECT * FROM students WHERE student_id=#{studentId}
          """)
  Student getStudentById(Long studentId);

  @ResultMap("studentMapper")
  @Select("""
          UPDATE students SET student_name = #{req.studentName}, email = #{req.email}, phone_number = #{req.phoneNumber} WHERE student_id = #{studentId} RETURNING *;
          """)
  Student updateStudentById(@Param("req") StudentRequest request, Long studentId);

  @ResultMap("studentMapper")
  @Select("""
          DELETE FROM students WHERE student_id=#{studentId} RETURNING *;
          """)
  Student deleteStudentById(Long studentId);

}
