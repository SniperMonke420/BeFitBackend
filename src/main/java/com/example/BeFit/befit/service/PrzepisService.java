package com.example.BeFit.befit.service;

import com.example.BeFit.befit.model.Przepis;
import com.example.BeFit.befit.model.PrzepisSkladniki;
import com.example.BeFit.befit.repository.PrzepisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrzepisService {

    private final PrzepisRepository przepisRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<List<Przepis>> getAllPrzepisy() {
        List<Przepis> przepisy = przepisRepository.findAll();
        if (przepisy.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(przepisy);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Przepis> getPrzepisById(Long id) {
        return przepisRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Transactional
    public ResponseEntity<Przepis> savePrzepis(Przepis przepis) {
        Przepis savedPrzepis = przepisRepository.save(przepis);
        return ResponseEntity.ok(savedPrzepis);
    }

    @Transactional
    public ResponseEntity<Przepis> updatePrzepis(Przepis przepis, Long id) {
        return przepisRepository.findById(id)
                .map(existingPrzepis -> {
                    existingPrzepis.setNazwa(przepis.getNazwa());
                    existingPrzepis.setPrzygotowanie(przepis.getPrzygotowanie());

                    // Ustawienie przepis_id dla każdego składnika
                    for (PrzepisSkladniki skladnik : przepis.getSkladniki()) {
                        skladnik.setPrzepis(existingPrzepis);
                    }

                    existingPrzepis.getSkladniki().clear();
                    existingPrzepis.getSkladniki().addAll(przepis.getSkladniki());

                    Przepis updatedPrzepis = przepisRepository.save(existingPrzepis);
                    return ResponseEntity.ok(updatedPrzepis);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Transactional
    public ResponseEntity<Void> deletePrzepis(Long id) {
        return przepisRepository.findById(id)
                .map(existingPrzepis -> {
                    przepisRepository.delete(existingPrzepis);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
