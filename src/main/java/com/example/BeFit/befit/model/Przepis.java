package com.example.BeFit.befit.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Przepis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nazwa", nullable = false)
    private String nazwa;

    @Column(name = "przygotowanie", columnDefinition = "TEXT")
    private String przygotowanie;

    @JsonManagedReference
    @OneToMany(mappedBy = "przepis", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PrzepisSkladniki> skladniki;
}
