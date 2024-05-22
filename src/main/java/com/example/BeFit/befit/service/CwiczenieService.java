package com.example.BeFit.befit.service;

import com.example.BeFit.befit.model.Cwiczenie;
import com.example.BeFit.befit.repository.CwiczenieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CwiczenieService {
    private final CwiczenieRepository cwiczenieRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<List<Cwiczenie>> findAllCwiczenia(){
        List<Cwiczenie> cwiczenia = cwiczenieRepository.findAll();
        if(cwiczenia.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cwiczenia);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Cwiczenie> findCwiczenieById(Long id){
        return cwiczenieRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Transactional
    public ResponseEntity<Cwiczenie> createCwiczenie(Cwiczenie cwiczenie){
        Cwiczenie savedCwiczenie = cwiczenieRepository.save(cwiczenie);
        return ResponseEntity.ok(savedCwiczenie);
    }

    @Transactional
    public ResponseEntity<Void> deleteCwiczenie(Long id){
        if (cwiczenieRepository.existsById(id)) {
            cwiczenieRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    public ResponseEntity<Cwiczenie> updateCwiczenie(Long id, Cwiczenie updatedCwiczenie){
        return cwiczenieRepository.findById(id)
                .map(existingCwiczenie -> {
                    updatedCwiczenie.setId(existingCwiczenie.getId());
                    Cwiczenie savedCwiczenie = cwiczenieRepository.save(updatedCwiczenie);
                    return ResponseEntity.ok(savedCwiczenie);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
