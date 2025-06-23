package com.naukri.database_api.controllers;

import com.naukri.database_api.models.Application_Form;
import com.naukri.database_api.repository.ApplicationFormRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/application_form")
public class Application_FormController {

    ApplicationFormRepository applicationFormRepository;
    public Application_FormController(ApplicationFormRepository applicationFormRepository){
        this.applicationFormRepository = applicationFormRepository;
    }

    @PostMapping("/save")
    public ResponseEntity<Application_Form> saveApplicationForm(@RequestBody Application_Form application_form){

        Application_Form applicationForm = applicationFormRepository.save(application_form);
        return new ResponseEntity<>(applicationForm, HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Application_Form> getApplicationFormById(@PathVariable UUID id){
        Application_Form applicationForm = applicationFormRepository.findById(id).orElse(null);
        return new ResponseEntity<>(applicationForm, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Application_Form>> getAllApplicationForm(){
        List<Application_Form> applicationFormList = applicationFormRepository.findAll();
        return new ResponseEntity<>(applicationFormList, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Application_Form> updateApplicationForm(@RequestBody Application_Form application_form){
        Application_Form applicationForm = applicationFormRepository.save(application_form);
        return new ResponseEntity<>(applicationForm, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteApplicationFormById(@PathVariable UUID id){
        applicationFormRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
