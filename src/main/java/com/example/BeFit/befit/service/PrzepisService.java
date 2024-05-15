package com.example.BeFit.befit.service;

import com.example.BeFit.befit.model.Przepis;
import com.example.BeFit.befit.repository.PrzepisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrzepisService {
    @Autowired
    private final PrzepisRepository przepisRepository;

    public PrzepisService(PrzepisRepository przepisRepository) {
        this.przepisRepository = przepisRepository;
    }

    public List<Przepis> getAllPrzepisy() {
        return przepisRepository.findAll();
    }

    public Przepis getPrzepisById(Long id) {
        return przepisRepository.findById(id).orElse(null);
    }

    public Przepis savePrzepis(Przepis przepis) {
        return przepisRepository.save(przepis);
    }
}
