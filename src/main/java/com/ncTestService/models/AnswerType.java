package com.ncTestService.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "answer_type")
public class AnswerType {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, columnDefinition = "text", unique =  true)
    private String type;

    public AnswerType(String type) {
        this.type = type;
    }
}
