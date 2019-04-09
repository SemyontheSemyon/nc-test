package com.ncTestService.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Data
@RequiredArgsConstructor
@Entity
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

}
