package com.poly.quizapi.controllers;

import com.poly.quizapi.models.Question;
import com.poly.quizapi.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("questions")
public class QuestionController {

    QuestionService service;

    @Autowired
    public QuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("test")
    public String test() {
        return "Hello from " + QuestionController.class.getName();
    }

    @PostMapping
    public ResponseEntity<Question> create(@RequestBody final Question question) {
        return service.create();
    }

    @GetMapping("{id}")
    public ResponseEntity<Question> getById(@PathVariable Integer id) {
        return service.getById();
    }

    @PutMapping("{id}")
    public ResponseEntity<Question> updateById(@PathVariable Integer id) {
        return service.updateById();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Question> deleteById(@PathVariable Integer id) {
        return service.deleteById();
    }
}
