package com.ncTestService.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "test_user")
public class TestUser {

    @Id
    @GeneratedValue
    Long id;

    @Column(nullable = false, columnDefinition = "boolean")
    boolean correct;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "test_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    Test test;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    Question question;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "answer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
<<<<<<< HEAD
    Answer Answer;
=======
    Answer answer;

    @Column(columnDefinition = "text", name = "student_answer")
    String studentAnswer;

    protected TestUser() {
    }

    public TestUser(boolean correct, Test test, Question question, Answer answer) {
        this.correct = correct;
        this.test = test;
        this.question = question;
        this.answer = answer;
    }
>>>>>>> master

}
