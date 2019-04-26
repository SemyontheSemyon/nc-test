package com.ncTestService.models;


import lombok.Data;
import lombok.NoArgsConstructor;
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

    @Column(nullable = false, columnDefinition = "text", name = "app_start")
    private String appStart;

    @Column(nullable = false, columnDefinition = "text", name = "app_end")
    private String appEnd;

    @Column(nullable = false, columnDefinition = "text", name = "test_start")
    private String testStart;

    @Column(nullable = false, columnDefinition = "text", name = "test_end")
    private String testEnd;

    @Column(nullable = true, columnDefinition = "text", name = "created_at")
    private String createdAt;

    public Enrollment(Speciality speciality, String appStart, String appEnd, String testStart, String testEnd, String createdAt) {
        this.speciality = speciality;
        this.appStart = appStart;
        this.appEnd = appEnd;
        this.testStart = testStart;
        this.testEnd = testEnd;
        this.createdAt = createdAt;
    }
}
