package com.both.Online.Learning.Platform.services.ServiceImplement;

import com.both.Online.Learning.Platform.models.entity.Instructor;
import com.both.Online.Learning.Platform.models.request.InstructorRequest;
import com.both.Online.Learning.Platform.models.response.APIResponseInstructor;
import com.both.Online.Learning.Platform.repositories.IInstructorRepo;
import com.both.Online.Learning.Platform.services.IInstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InstructorService implements IInstructorService {

  private final IInstructorRepo instructorRepo;


  public InstructorService(IInstructorRepo instructorRepo) {
    this.instructorRepo = instructorRepo;
  }


  @Override
  public ResponseEntity<APIResponseInstructor<List<Instructor>>> getAllInstructors() {

    List<Instructor> instructors = instructorRepo.getAllInstructors();

    APIResponseInstructor<List<Instructor>> response = new APIResponseInstructor<>("All instructors have been successfully fetched.", instructors, HttpStatus.OK, LocalDateTime.now());

    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<APIResponseInstructor<Instructor>> createInstructor(InstructorRequest request) {
    Instructor instructor = instructorRepo.createInstructor(request);

    APIResponseInstructor<Instructor> response = new APIResponseInstructor<>("instructor have been successfully created.", instructor, HttpStatus.CREATED, LocalDateTime.now());

    return ResponseEntity.ok().body(response);

  }

  @Override
  public ResponseEntity<APIResponseInstructor<Instructor>> getInstructorById(Long instructorId) {
    Instructor instructor = instructorRepo.getInstructorById(instructorId);

    APIResponseInstructor<Instructor> response = new APIResponseInstructor<>("instructor have been successfully founded.", instructor, HttpStatus.OK, LocalDateTime.now());

    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<APIResponseInstructor<Instructor>> updateInstructorById(InstructorRequest request, Long instructorId) {
    Instructor instructor = instructorRepo.updateInstructorById(request, instructorId);

    APIResponseInstructor<Instructor> response = new APIResponseInstructor<>("instructor have been successfully updated.", instructor, HttpStatus.OK, LocalDateTime.now());

    return ResponseEntity.ok().body(response);


  }

  @Override
  public ResponseEntity<APIResponseInstructor<Instructor>> deleteInstructorById(Long instructorId) {

    Instructor instructor = instructorRepo.deleteInstructorById(instructorId);

    APIResponseInstructor<Instructor> response = new APIResponseInstructor<>("instructor have been successfully deleted.", instructor, HttpStatus.OK, LocalDateTime.now());

    return ResponseEntity.ok().body(response);

  }

}
