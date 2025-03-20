package com.both.Online.Learning.Platform.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
  private String StudentName;
  private String email;
  private String phoneNumber;
  private List<Long> courseId;
}
