package com.both.Online.Learning.Platform.services;

import com.both.Online.Learning.Platform.models.entity.Instructor;
import com.both.Online.Learning.Platform.models.request.InstructorRequest;
import com.both.Online.Learning.Platform.models.response.APIResponseInstructor;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IInstructorService {

  ResponseEntity<APIResponseInstructor<List<Instructor>>> getAllInstructors();

  ResponseEntity<APIResponseInstructor<Instructor>> createInstructor(InstructorRequest request);

  ResponseEntity<APIResponseInstructor<Instructor>> getInstructorById(Long instructorId);

  ResponseEntity<APIResponseInstructor<Instructor>> updateInstructorById(InstructorRequest request, Long instructorId);

  ResponseEntity<APIResponseInstructor<Instructor>> deleteInstructorById(Long instructorId);
}
