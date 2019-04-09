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
@Table(name = "user_core")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, columnDefinition = "text", unique = true)
    private String login;

    @Column(nullable = false, columnDefinition = "text")
    private String password;

    @Column(nullable = false, columnDefinition = "integer")
    private int Authority;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_info_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserInfo userInfo;

}
