package com.both.Online.Learning.Platform.controllers;

import com.both.Online.Learning.Platform.models.entity.Instructor;
import com.both.Online.Learning.Platform.models.request.InstructorRequest;
import com.both.Online.Learning.Platform.models.response.APIResponseInstructor;
import com.both.Online.Learning.Platform.services.ServiceImplement.InstructorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {

  private final InstructorService instructorService;


  public InstructorController(InstructorService instructorService) {
    this.instructorService = instructorService;
  }

  @GetMapping
  public ResponseEntity<APIResponseInstructor<List<Instructor>>> getAllInstructors() {
    return instructorService.getAllInstructors();
  }

  @PostMapping
  public ResponseEntity<APIResponseInstructor<Instructor>> createInstructor(@RequestBody InstructorRequest request) {
    return instructorService.createInstructor(request);
  }

  @GetMapping("/{instructor-id}")
  public ResponseEntity<APIResponseInstructor<Instructor>> getInstructorById(@PathVariable("instructor-id") Long instructorId) {
    return instructorService.getInstructorById(instructorId);
  }

  @PutMapping("/{instructor-id}")
  public ResponseEntity<APIResponseInstructor<Instructor>> updateInstructorById(@RequestBody InstructorRequest request, @PathVariable("instructor-id") Long instructorId) {
    return instructorService.updateInstructorById(request, instructorId);
  }


  @DeleteMapping("/{instructor-id}")
  public ResponseEntity<APIResponseInstructor<Instructor>> deleteInstructorById(@PathVariable("instructor-id") Long instructorId) {
    return instructorService.deleteInstructorById(instructorId);
  }
}
