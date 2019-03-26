package com.ncTestService.models;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "spec_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Speciality speciality;

    protected TestFormat() {
    }

    public TestFormat(int time, int numberOfQuestions, Speciality speciality) {
        this.time = time;
        this.numberOfQuestions = numberOfQuestions;
        this.speciality = speciality;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
}
