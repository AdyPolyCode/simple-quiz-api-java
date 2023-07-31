package com.poly.quizapi.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "quiz")
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "category", nullable = false)
    private String category;

    @ManyToMany(targetEntity = Question.class)
    @Column(name = "questions")
    private List<Question> questions;
}
