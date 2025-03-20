package com.both.Online.Learning.Platform.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseCourse<T> {
  private String message;
  private T payload;
  private HttpStatus status;
  private LocalDateTime time;
}
