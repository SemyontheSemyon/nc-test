package com.ncTestService.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "test_format")
public class TestFormat {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, columnDefinition = "integer")
    private int time;

    @Column(nullable = false, columnDefinition = "integer", name = "number_of_questions")
    private int numberOfQuestions;
    
    @Column(nullable = false, columnDefinition = "integer")
    private int threshold;

    public TestFormat(int time, int numberOfQuestions, int threshold) {
        this.time = time;
        this.numberOfQuestions = numberOfQuestions;
        this.threshold = threshold;
    }
}
