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
@NoArgsConstructor
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

}
