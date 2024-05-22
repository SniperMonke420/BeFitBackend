package com.example.BeFit.befit.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cwiczenie")
public class Cwiczenie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 300)
    private String link;
    @Column(length = 300)
    private String kategoria;
}
