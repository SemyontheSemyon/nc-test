package com.ncTestService.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "db_status")
@Data
@RequiredArgsConstructor
public class DBStatus {

    @Id
    @GeneratedValue
    Long id;

    @Column(nullable = false, columnDefinition = "boolean")
    boolean inited;

    public DBStatus(boolean inited) {
        this.inited = inited;
    }
}
