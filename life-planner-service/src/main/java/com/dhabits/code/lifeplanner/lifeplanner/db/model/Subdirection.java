package com.dhabits.code.lifeplanner.lifeplanner.db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "main_direction_id")
    private MainDirection mainDirection;

}
