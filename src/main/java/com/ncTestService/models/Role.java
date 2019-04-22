package com.ncTestService.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue
    Long id;

    @Column(nullable = false, columnDefinition = "text", unique = true)
    String name;

    public Role(String name) {
        this.name = name;
    }
}
