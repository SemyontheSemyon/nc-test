package com.ncTestService.models;


import lombok.Data;
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
    private String shortDescription;

    @Column(nullable = false, columnDefinition = "text")
    private String fullDescription;

    public Speciality(String name, String shortDescription, String fullDescription) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
    }
}
