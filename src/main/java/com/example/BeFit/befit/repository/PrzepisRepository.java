package com.example.BeFit.befit.repository;

import com.example.BeFit.befit.model.Przepis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrzepisRepository extends JpaRepository<Przepis, Long> {
}

