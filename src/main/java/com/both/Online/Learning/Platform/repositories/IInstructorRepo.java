package com.both.Online.Learning.Platform.repositories;

import com.both.Online.Learning.Platform.models.entity.Instructor;
import com.both.Online.Learning.Platform.models.request.InstructorRequest;
import com.both.Online.Learning.Platform.models.response.APIResponseInstructor;
import org.apache.ibatis.annotations.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Mapper
public interface IInstructorRepo {

  @Results(id = "instructorMapper", value = {
          @Result(property = "instructorId", column = "instructor_id"),
          @Result(property = "instructorName", column = "instructor_name"),
          @Result(property = "email", column = "email")})
  @Select("""
          SELECT * FROM instructors OFFSET #{offset} LIMIT #{size};
          """)
  List<Instructor> getAllInstructors(int offset, Integer size);


  @ResultMap("instructorMapper")
  @Select("""
          INSERT INTO instructors VALUES (default, #{req.instructorName}, #{req.email} ) RETURNING *;
          """)
  Instructor createInstructor(@Param("req") InstructorRequest request);

  @ResultMap("instructorMapper")
  @Select("""
          SELECT * FROM instructors WHERE instructor_id = #{instructorId}
          """)
  Instructor getInstructorById(Long instructorId);

  @ResultMap("instructorMapper")
  @Select("""
          UPDATE instructors SET  instructor_name = #{req.instructorName}, email = #{req.email} WHERE instructor_id = #{instructorId} RETURNING *;
          """)
  Instructor updateInstructorById(@Param("req") InstructorRequest request, Long instructorId);

  @ResultMap("instructorMapper")
  @Select("""
          DELETE FROM instructors WHERE instructor_id=#{instructorId}
          """)
  Instructor deleteInstructorById(Long instructorId);


}
