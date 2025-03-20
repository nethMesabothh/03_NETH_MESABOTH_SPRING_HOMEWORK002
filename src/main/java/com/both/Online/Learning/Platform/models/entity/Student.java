package com.both.Online.Learning.Platform.models.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
  private Long studentId;
  private String StudentName;
  private String email;
  private String phoneNumber;
  private List<Course> courses;
}
