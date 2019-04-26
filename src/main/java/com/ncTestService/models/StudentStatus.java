package com.ncTestService.models;

import javax.persistence.*;

@Entity
@Table(name = "student_status")
public class StudentStatus {

    @Id
    @GeneratedValue
    Long id;

    @Column(nullable = false, unique = true, columnDefinition = "text")
    String name;

}
