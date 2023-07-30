package com.poly.quizapi.services;

import com.poly.quizapi.models.Question;
import com.poly.quizapi.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    QuestionRepository repository;

    @Autowired
    public QuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<Question> create() {
        Question question = null;
        return new ResponseEntity<>(
                question,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Question> getById() {
        Question question = null;
        return new ResponseEntity<>(
                question,
                HttpStatus.OK
        );
    }

    public ResponseEntity<Question> updateById() {
        Question question = null;
        return new ResponseEntity<>(
                question,
                HttpStatus.OK
        );
    }

    public ResponseEntity<Question> deleteById() {
        Question question = null;
        return new ResponseEntity<>(
                question,
                HttpStatus.NO_CONTENT
        );
    }
}
