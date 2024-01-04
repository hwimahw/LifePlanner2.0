package com.dhabits.code.lifeplanner.lifeplanner.db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "subdirection", schema = "lifeplanner")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subdirection {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "idf")
    private Integer idf;

    @Column(name = "name")
    private String name;

    @Column(name = "parentIdf")
    private Integer parentIdf;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "main_direction_id")
    private MainDirection mainDirection;
}
