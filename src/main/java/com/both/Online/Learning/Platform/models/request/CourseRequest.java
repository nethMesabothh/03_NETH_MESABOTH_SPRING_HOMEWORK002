package com.both.Online.Learning.Platform.models.request;


import com.both.Online.Learning.Platform.models.entity.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
  private String courseName;
  private String description;
  private Long instructorId;
}
