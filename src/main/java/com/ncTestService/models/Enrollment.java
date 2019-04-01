package com.ncTestService.models;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "enrollment")
public class Enrollment {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "spec_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Speciality speciality;

    @Column(nullable = false, columnDefinition = "date", name = "app_start")
    private Date appStart;

    @Column(nullable = false, columnDefinition = "date", name = "app_end")
    private Date appEnd;

    @Column(nullable = false, columnDefinition = "date", name = "test_start")
    private Date testStart;

    @Column(nullable = false, columnDefinition = "date", name = "test_end")
    private Date testEnd;

    @Column(nullable = false, columnDefinition = "date", name = "created_at")
    private Date createdAt;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private City city;

}
