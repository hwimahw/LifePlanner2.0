package com.dhabits.code.lifeplanner.lifeplanner.db.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
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
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "mainDirection")
    Set<Subdirection> subdirections;
}
