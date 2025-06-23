package com.naukri.database_api.controllers;

import com.naukri.database_api.models.FormSubmission;
import com.naukri.database_api.repository.FormSubmissionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/form_submission")
public class FormSubmissionController {

    FormSubmissionRepository formSubmissionRepository;
    public FormSubmissionController(FormSubmissionRepository formSubmissionRepository){
        this.formSubmissionRepository = formSubmissionRepository;
    }

    @PostMapping("/save")
    public ResponseEntity saveFormSubmission(FormSubmission formSubmission){
        formSubmissionRepository.save(formSubmission);
        return new ResponseEntity(formSubmission, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<FormSubmission>> getAllFormSubmission(){
        Iterable<FormSubmission> formSubmissionList = formSubmissionRepository.findAll();
        return new ResponseEntity<>(formSubmissionList, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<FormSubmission> getFormSubmissionById(@PathVariable UUID id){
        FormSubmission formSubmission = formSubmissionRepository.findById(id).orElse(null);
        return new ResponseEntity<>(formSubmission, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateFormSubmission(@RequestBody FormSubmission formSubmission){
        formSubmissionRepository.save(formSubmission);
        return new ResponseEntity(formSubmission, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteFormSubmissionById(@PathVariable UUID id){
        formSubmissionRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
