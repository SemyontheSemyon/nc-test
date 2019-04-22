package com.ncTestService.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "speciality")
public class Speciality {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, columnDefinition = "text", unique = true)
    private String name;

    @Column(nullable = false, columnDefinition = "text")
    private String description;

    public Speciality(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
