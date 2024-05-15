package com.example.BeFit.befit.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Przepis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 1500)
    private String nazwa;
    @ElementCollection
    private List<String> skladniki;
    @Column(length = 1500)
    private String przygotowanie;

    // Gettery i settery
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public List<String> getSkladniki() {
        return skladniki;
    }

    public void setSkladniki(List<String> skladniki) {
        this.skladniki = skladniki;
    }

    public String getPrzygotowanie() {
        return przygotowanie;
    }

    public void setPrzygotowanie(String przygotowanie) {
        this.przygotowanie = przygotowanie;
    }
}