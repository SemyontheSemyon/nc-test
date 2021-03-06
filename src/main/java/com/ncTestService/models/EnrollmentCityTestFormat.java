package com.ncTestService.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "enrollment_city_test_format")
public class EnrollmentCityTestFormat {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "enrollment_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Enrollment enrollment;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "city_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private City city;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "test_format_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TestFormat testFormat;


    @Column(columnDefinition = "boolean", name = "is_active")
    private boolean active;

    public EnrollmentCityTestFormat(Enrollment enrollment, City city, TestFormat testFormat) {
        this.enrollment = enrollment;
        this.city = city;
        this.testFormat = testFormat;
    }
}
