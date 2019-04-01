package com.ncTestService.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, columnDefinition = "text", unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    Country country;

}
