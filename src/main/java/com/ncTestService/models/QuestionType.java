package com.ncTestService.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "question_type")
public class QuestionType {

    @Id
    @GeneratedValue
    Long id;

    @Column(nullable = false, unique = true, columnDefinition = "text")
    String name;

    public QuestionType(String name) {
        this.name = name;
    }
}
