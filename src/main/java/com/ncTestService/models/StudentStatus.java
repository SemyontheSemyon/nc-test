package com.ncTestService.models;


import javax.persistence.*;

@Entity
@Table(name = "student_status")
public class StudentStatus {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, columnDefinition = "text", unique = true)
    private String name;

    protected StudentStatus() {
    }

    public StudentStatus(String name) {
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
