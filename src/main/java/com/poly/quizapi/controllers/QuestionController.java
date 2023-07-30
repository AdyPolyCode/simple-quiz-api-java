package com.poly.quizapi.controllers;

import com.poly.quizapi.models.Question;
import com.poly.quizapi.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return "Hello from " + QuestionController.class.getSimpleName();
    }

    @PostMapping
    public ResponseEntity<Question> create(@RequestBody final Question question) {
        return service.create(question);
    }

    @GetMapping
    public ResponseEntity<List<Question>> getAll() {
        return service.getAll();
    }

    @GetMapping("random")
    public ResponseEntity<List<Question>> getSomeByCategory(@RequestParam(name = "category") String cat, @RequestParam(name = "numberOfCategories") Integer numOfCat) {
        return service.getSomeByCategory(cat, numOfCat);
    }

    @GetMapping("{id}")
    public ResponseEntity<Question> getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Question> updateById(@RequestBody final Question question, @PathVariable Integer id) {
        return service.updateById(id, question);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Question> deleteById(@PathVariable Integer id) {
        return service.deleteById(id);
    }
}
