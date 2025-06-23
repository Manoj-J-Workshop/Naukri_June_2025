package com.naukri.database_api.controllers;

import com.naukri.database_api.models.Questions;
import com.naukri.database_api.repository.QuestionsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/questions")
public class QuestionsController {

    QuestionsRepository questionsRepository;
    public QuestionsController(QuestionsRepository questionsRepository){
        this.questionsRepository = questionsRepository;
    }

    @PostMapping("/save")
    public ResponseEntity saveQuestions(@RequestBody Questions questions){
        questionsRepository.save(questions);
        return new ResponseEntity(questions, HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Questions> getQuestionById(@PathVariable UUID id){
        Questions questions = questionsRepository.findById(id).orElse(null);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Questions>> getAllQuestions(){
        List<Questions> questionsList = questionsRepository.findAll();
        return new ResponseEntity<>(questionsList,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Questions> updateQuestions(@RequestBody Questions questions){
        questionsRepository.save(questions);
        return new ResponseEntity<>(questions,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteQuestionsById(@PathVariable UUID id){
        questionsRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
