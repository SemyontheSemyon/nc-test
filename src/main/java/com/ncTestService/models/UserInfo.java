package com.ncTestService.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_info")
public class UserInfo {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "user")
    private User user;

    @Column(nullable = false, columnDefinition = "text", unique =  true)
    private String email;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "status_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private StudentStatus studentStatus;

    @Column(nullable = false, columnDefinition = "text", name = "first_name")
    private String firstName;

    @Column(nullable = false, columnDefinition = "text", name = "last_name")
    private String lastName;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private City city;

    @Column(nullable = false, columnDefinition = "text")
    private String phone;

    @Column(nullable = false, columnDefinition = "integer")
    private int grade;

    @Column(columnDefinition = "text")
    private String university;

    @Column(columnDefinition = "text")
    private String department;

    @Column(columnDefinition = "text")
    private String specialty;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "source_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Source source;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enrollment_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Enrollment enrollment;

}
