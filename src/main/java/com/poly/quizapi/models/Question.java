package com.poly.quizapi.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "question")
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "answer_1", nullable = false)
    private String answerOne;

    @Column(name = "answer_2", nullable = false)
    private String answerTwo;

    @Column(name = "answer_3", nullable = false)
    private String answerThree;

    @Column(name = "answer_4", nullable = false)
    private String answerFour;

    @Column(name = "right_answer", nullable = false)
    private String rightAnswer;
}
