package com.poly.quizapi.repositories;

import com.poly.quizapi.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    @Query("SELECT q FROM Question q WHERE q.category = :cat ORDER BY RANDOM() LIMIT :numberOfQuestion")
    List<Question> findSomeByCategory(String cat, int numberOfQuestion);
}
