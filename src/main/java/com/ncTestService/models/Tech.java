package com.ncTestService.models;

import javax.persistence.*;

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

    protected Tech() {}

    public Tech(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
