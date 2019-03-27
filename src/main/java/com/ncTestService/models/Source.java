package com.ncTestService.models;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "source")
public class Source {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, columnDefinition = "text", unique = true)
    private String name;

}
