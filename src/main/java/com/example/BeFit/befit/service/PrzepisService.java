package com.example.BeFit.befit.service;

import com.example.BeFit.befit.model.Przepis;
import com.example.BeFit.befit.model.PrzepisSkladniki;
import com.example.BeFit.befit.repository.PrzepisRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PrzepisService {

    private final PrzepisRepository przepisRepository;

    private final FileService fileService;

    private final ObjectMapper objectMapper;

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
    public ResponseEntity<Przepis> savePrzepis(String przepisJson, MultipartFile image) throws IOException {
        Przepis przepis = objectMapper.readValue(przepisJson, Przepis.class);
        if (!image.isEmpty()) {
            String imagePath = fileService.saveFile(image, "przepisy");
            przepis.setImagePath(imagePath);
        }
        return ResponseEntity.ok(przepisRepository.save(przepis));
    }

    @Transactional
    public ResponseEntity<Przepis> updatePrzepis(String przepisJson, Long id, MultipartFile image) throws JsonProcessingException {
        Przepis przepis = objectMapper.readValue(przepisJson, Przepis.class);
        return przepisRepository.findById(id)
                .map(existingPrzepis -> {
                    existingPrzepis.setNazwa(przepis.getNazwa());
                    existingPrzepis.setPrzygotowanie(przepis.getPrzygotowanie());

                    for (PrzepisSkladniki skladnik : przepis.getSkladniki()) {
                        skladnik.setPrzepis(existingPrzepis);
                    }

                    existingPrzepis.getSkladniki().clear();
                    existingPrzepis.getSkladniki().addAll(przepis.getSkladniki());
                    if (!image.isEmpty()) {
                        String imagePath = null;
                        try {
                            imagePath = fileService.saveFile(image, "przepisy");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        przepis.setImagePath(imagePath);
                    }
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
