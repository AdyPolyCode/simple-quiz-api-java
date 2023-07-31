package com.poly.quizapi.services;

import com.poly.quizapi.controllers.QuestionController;
import com.poly.quizapi.models.Question;
import com.poly.quizapi.models.Quiz;
import com.poly.quizapi.repositories.QuizRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    private static final Logger LOG = LoggerFactory.getLogger(QuestionController.class);

    QuizRepository quizRepository;

    QuestionService questionService;

    @Autowired
    public QuizService(QuizRepository quizRepository, QuestionService questionService) {
        this.quizRepository = quizRepository;
        this.questionService = questionService;
    }

    public ResponseEntity<List<Quiz>> getAll() {
        List<Quiz> quiz = quizRepository.findAll();

        LOG.info("<GET> : " + Question.class.getSimpleName() + " ALL");

        return new ResponseEntity<>(
                quiz,
                HttpStatus.OK
        );
    }

    public ResponseEntity<List<Question>> getById(Integer id, Integer numOfQuestions) {
        Optional<Quiz> quiz = quizRepository.findById(id);

        LOG.info("<GET> : questions related to " + Quiz.class.getSimpleName() + " by id: " + id);

        return quiz.map(value -> questionService.getSomeByCategory(value.getCategory(), numOfQuestions)
        ).orElseGet(() -> new ResponseEntity<>(
                null,
                HttpStatus.NOT_FOUND
        ));
    }
}
