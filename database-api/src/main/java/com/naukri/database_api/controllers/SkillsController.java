package com.naukri.database_api.controllers;

import com.naukri.database_api.models.Skills;
import com.naukri.database_api.repository.SkillsRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/skills")
public class SkillsController {

    SkillsRepository skillsRepository;
    @Autowired
    public SkillsController(SkillsRepository skillsRepository){
        this.skillsRepository = skillsRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<Skills> addSkills(Skills skills){
        skillsRepository.save(skills);
        return new ResponseEntity<>(skills, HttpStatus.CREATED);
    }

    @GetMapping("/get/{SkillName}")
    public ResponseEntity<Skills> getSkillsByName(@PathVariable String SkillName){
        Skills skills = skillsRepository.findByName(SkillName);
        return new ResponseEntity<>(skills,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skills> getSkillsById(@PathVariable UUID id){
        Skills skills = skillsRepository.findById(id).orElse(null);
        return new ResponseEntity<>(skills,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Skills>> getAllSkills(){
        List<Skills> skillsList = skillsRepository.findAll();
        return new ResponseEntity<>(skillsList,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Skills> updateSkills(@RequestBody Skills skills){
        skillsRepository.save(skills);
        return new ResponseEntity<>(skills,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteSkills(@PathVariable UUID id){
        skillsRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
