package com.ncTestService.models;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "test")
public class Test {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, columnDefinition = "date", name = "taken_at")
    private Date takenAt;

    @Column(nullable = false, columnDefinition = "boolean")
    private boolean passed;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "test_format_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TestFormat testFormat;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    protected Test() {
    }

    public Test(Date takenAt, boolean passed, TestFormat testFormat, User user) {
        this.takenAt = takenAt;
        this.passed = passed;
        this.testFormat = testFormat;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTakenAt() {
        return takenAt;
    }

    public void setTakenAt(Date takenAt) {
        this.takenAt = takenAt;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public TestFormat getTestFormat() {
        return testFormat;
    }

    public void setTestFormat(TestFormat testFormat) {
        this.testFormat = testFormat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
