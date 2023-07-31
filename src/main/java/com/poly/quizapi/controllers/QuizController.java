package com.poly.quizapi.controllers;

import com.poly.quizapi.models.Question;
import com.poly.quizapi.models.Quiz;
import com.poly.quizapi.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quizzes")
public class QuizController {

    QuizService service;

    @Autowired
    public QuizController(QuizService service) {
        this.service = service;
    }

    @RequestMapping("test")
    public String test() {
        return "Hello from " + QuizController.class.getSimpleName();
    }

    @GetMapping
    public ResponseEntity<List<Quiz>> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<List<Question>> getById(@PathVariable Integer id, @RequestParam(name = "numOfQuestions", defaultValue = "5") Integer numOfQuestions) {
        return service.getById(id, numOfQuestions);
    }
}
