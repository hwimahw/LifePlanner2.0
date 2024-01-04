package com.dhabits.code.lifeplanner.lifeplanner.db.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "main_direction", schema = "lifeplanner")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MainDirection {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "idf")
    private Integer idf;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "mainDirection")
    private Set<Subdirection> subdirections;
}
