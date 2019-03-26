package com.ncTestService.models;

import javax.persistence.*;

@Entity
@Table(name = "answer_type")
public class AnswerType {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, columnDefinition = "text", unique =  true)
    private String type;

    protected AnswerType() {
    }

    public AnswerType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
