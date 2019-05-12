package com.ncTestService.models;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "test_user")
public class TestUser {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, columnDefinition = "boolean")
    private boolean correct;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "test_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Test test;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Question question;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "answer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Answer Answer;

    @Column(nullable = false, columnDefinition = "text", name = "student_answer")
    private String studentAnswer;

}
