package com.poly.quizapi.services;

import com.poly.quizapi.controllers.QuestionController;
import com.poly.quizapi.models.Question;
import com.poly.quizapi.repositories.QuestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private static final Logger LOG = LoggerFactory.getLogger(QuestionController.class);

    QuestionRepository repository;

    @Autowired
    public QuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<Question> create(Question q) {
        Question question = repository.saveAndFlush(q);

        LOG.info("<CREATE> : " + Question.class.getSimpleName() + " with data: " + q);

        return new ResponseEntity<>(
                question,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Question> getById(Integer id) {
        Optional<Question> question = repository.findById(id);

        LOG.info("<GET> : " + Question.class.getSimpleName() + " by id: " + id);

        return question.map(value -> new ResponseEntity<>(
                value,
                HttpStatus.OK
        )).orElseGet(() -> new ResponseEntity<>(
                null,
                HttpStatus.NOT_FOUND
        ));
    }

    public ResponseEntity<Question> updateById(Integer id, Question q) {
        Optional<Question> question = repository.findById(id);

        LOG.info("<PUT> : " + Question.class.getSimpleName() + " by id: " + id + " with data: " + q);

        return question.map(value -> {
            value.setTitle(q.getTitle());
            value.setDescription(q.getDescription());
            value.setCategory(q.getCategory());
            value.setAnswerOne(q.getAnswerOne());
            value.setAnswerTwo(q.getAnswerTwo());
            value.setAnswerThree(q.getAnswerThree());
            value.setAnswerFour(q.getAnswerFour());
            value.setRightAnswer(q.getRightAnswer());

            repository.saveAndFlush(value);

            return new ResponseEntity<>(
                    value,
                    HttpStatus.OK
            );
                })
                .orElseGet(() -> new ResponseEntity<>(
                        new Question(),
                        HttpStatus.NOT_FOUND
                ));
    }

    public ResponseEntity<Question> deleteById(Integer id) {
        Optional<Question> question = repository.findById(id);

        LOG.info("<DELETE> : " + Question.class.getSimpleName() + " by id: " + id);

        return question.map(value -> {
                repository.delete(value);

                return new ResponseEntity<>(
                  question.get(),
                  HttpStatus.NO_CONTENT
                );
        }
        ).orElseGet(() ->
                new ResponseEntity<>(
                        null,
                        HttpStatus.NOT_FOUND
                )
        );
    }

    public ResponseEntity<List<Question>> getSomeByCategory(String cat, Integer numOfCat) {
        List<Question> questions = repository.findSomeByCategory(cat, numOfCat);

        LOG.info("<GET> : " + Question.class.getSimpleName() + " by category: " + cat + " and limit " + numOfCat);

        return new ResponseEntity<>(
                questions,
                HttpStatus.OK
        );
    }

    public ResponseEntity<List<Question>> getAll() {
        List<Question> questions = repository.findAll();

        LOG.info("<GET> : " + Question.class.getSimpleName() + " ALL");

        return new ResponseEntity<>(
                questions,
                HttpStatus.OK
        );
    }
}
