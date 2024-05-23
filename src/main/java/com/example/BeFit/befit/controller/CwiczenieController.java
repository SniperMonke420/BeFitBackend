package com.example.BeFit.befit.controller;

import com.example.BeFit.befit.model.Cwiczenie;
import com.example.BeFit.befit.service.CwiczenieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/cwiczenia")
@RequiredArgsConstructor
public class CwiczenieController {

    private final CwiczenieService cwiczenieService;

    @GetMapping
    public ResponseEntity<List<Cwiczenie>> getAllCwiczenia() {
        return cwiczenieService.findAllCwiczenia();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cwiczenie> getCwiczenieById(@PathVariable Long id) {
        return cwiczenieService.findCwiczenieById(id);
    }

    @PostMapping
    public ResponseEntity<Cwiczenie> createCwiczenie(@RequestParam String cwiczenie, @RequestParam MultipartFile image) throws IOException {
        return cwiczenieService.createCwiczenie(cwiczenie, image);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCwiczenie(@PathVariable Long id) {
        return cwiczenieService.deleteCwiczenie(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cwiczenie> updateCwiczenie(@PathVariable Long id, @RequestParam String cwiczenie, @RequestParam MultipartFile image) throws IOException {
        return cwiczenieService.updateCwiczenie(id, cwiczenie, image);
    }
}
