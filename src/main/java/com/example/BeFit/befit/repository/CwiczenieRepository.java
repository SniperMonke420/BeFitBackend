package com.example.BeFit.befit.repository;

import com.example.BeFit.befit.model.Cwiczenie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CwiczenieRepository extends JpaRepository<Cwiczenie, Long> {
}
