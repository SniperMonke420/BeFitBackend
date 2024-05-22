package com.example.BeFit.befit.repository;

import com.example.BeFit.befit.model.PrzepisSkladniki;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrzepisSkladnikiRepository extends JpaRepository<PrzepisSkladniki, Long> {
}