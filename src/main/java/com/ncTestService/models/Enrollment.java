package com.ncTestService.models;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

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

    protected Enrollment() {
    }

    public Enrollment(Speciality speciality, Date appStart, Date appEnd, Date testStart, Date testEnd, Date createdAt, City city) {
        this.speciality = speciality;
        this.appStart = appStart;
        this.appEnd = appEnd;
        this.testStart = testStart;
        this.testEnd = testEnd;
        this.createdAt = createdAt;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Date getAppStart() {
        return appStart;
    }

    public void setAppStart(Date appStart) {
        this.appStart = appStart;
    }

    public Date getAppEnd() {
        return appEnd;
    }

    public void setAppEnd(Date appEnd) {
        this.appEnd = appEnd;
    }

    public Date getTestStart() {
        return testStart;
    }

    public void setTestStart(Date testStart) {
        this.testStart = testStart;
    }

    public Date getTestEnd() {
        return testEnd;
    }

    public void setTestEnd(Date testEnd) {
        this.testEnd = testEnd;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
