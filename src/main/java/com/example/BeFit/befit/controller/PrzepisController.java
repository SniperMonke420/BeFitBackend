package com.example.BeFit.befit.controller;

import com.example.BeFit.befit.model.Przepis;
import com.example.BeFit.befit.service.PrzepisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Przepis> savePrzepis(@RequestBody Przepis przepis) {
        return przepisService.savePrzepis(przepis);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Przepis> updatePrzepis(@PathVariable Long id, @RequestBody Przepis przepis) {
        return przepisService.updatePrzepis(przepis, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrzepis(@PathVariable Long id) {
        return przepisService.deletePrzepis(id);
    }
}
