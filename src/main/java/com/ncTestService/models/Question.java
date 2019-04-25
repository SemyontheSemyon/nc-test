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
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, columnDefinition = "text", unique = true)
    private String text;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "spec_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Speciality speciality;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "question_type_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private QuestionType questionType;

}
