package com.dhabits.code.lifeplanner.lifeplanner.db.model;

import jakarta.persistence.*;
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

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "mainDirection")
    private Set<Subdirection> subdirections;
}
