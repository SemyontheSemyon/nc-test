package com.ncTestService.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "tech")
public class Tech {

    @Id
    @GeneratedValue
    private Long id;

    @Column(columnDefinition = "text",
            nullable = false,
            unique = true)
    private String name;

}
