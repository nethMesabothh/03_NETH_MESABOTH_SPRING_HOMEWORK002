package com.both.Online.Learning.Platform.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorRequest {
  private String instructorName;
  private String email;
}
