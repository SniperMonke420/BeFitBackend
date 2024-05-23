package com.example.BeFit.befit.controller;

import com.example.BeFit.befit.model.Przepis;
import com.example.BeFit.befit.service.PrzepisService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/przepisy")
@RequiredArgsConstructor
public class PrzepisController {

    private final PrzepisService przepisService;

    @GetMapping
    public ResponseEntity<List<Przepis>> getAllPrzepisy() {
        return przepisService.getAllPrzepisy();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Przepis> getPrzepisById(@PathVariable Long id) {
        return przepisService.getPrzepisById(id);
    }

    @PostMapping
    public ResponseEntity<Przepis> savePrzepis(@RequestParam String przepis, @RequestParam MultipartFile image) throws IOException {
        return przepisService.savePrzepis(przepis, image);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Przepis> updatePrzepis(@PathVariable Long id, @RequestParam String przepis, @RequestParam MultipartFile image) throws JsonProcessingException {
        return przepisService.updatePrzepis(przepis, id, image);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrzepis(@PathVariable Long id) {
        return przepisService.deletePrzepis(id);
    }
}
