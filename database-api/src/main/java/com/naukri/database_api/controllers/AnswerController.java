package com.naukri.database_api.controllers;

import com.naukri.database_api.models.Answer;
import com.naukri.database_api.repository.AnswerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/answer")
public class AnswerController {

    AnswerRepository answerRepository;
    public AnswerController(AnswerRepository answerRepository){
        this.answerRepository = answerRepository;
    }

    @PostMapping("/save")
    public ResponseEntity addAnswer(Answer answer){
        answerRepository.save(answer);
        return new ResponseEntity (answer, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable UUID id){
        Answer answer = answerRepository.findById(id).orElse(null);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Answer>> getAllanswer(){
        List<Answer> answerList = answerRepository.findAll();
        return new ResponseEntity<>(answerList, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateAnswer(@RequestBody Answer answer){
        Answer answer1 = answerRepository.save(answer);
        return new ResponseEntity(answer1, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAnswerById(@PathVariable UUID id){
        answerRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
