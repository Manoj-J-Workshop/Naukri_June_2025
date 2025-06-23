package com.naukri.database_api.controllers;

import com.naukri.database_api.models.Job;
import com.naukri.database_api.repository.JobRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/job")
public class JobController {

    JobRepository jobRepository;
    @Autowired
    public JobController(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }

    @PostMapping("/create_post")
    public ResponseEntity<Job> createPost(@RequestBody Job job){
        jobRepository.save(job);
        return new ResponseEntity<>(job, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> jobById(@PathVariable UUID id){
        Job job = jobRepository.findById(id).orElse(null);
        return new ResponseEntity<>(job, HttpStatus.OK);

    }

    @GetMapping("/get/All")
    public ResponseEntity<List<Job>> getAllJob(){
        List<Job> joblist = jobRepository.findAll();
        return new ResponseEntity<>(joblist, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Job> updatejob(@RequestBody Job job){
        jobRepository.save(job);
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJob(@PathVariable UUID id){
        jobRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
