package com.example.BeFit.befit.controller;

import com.example.BeFit.befit.model.Cwiczenie;
import com.example.BeFit.befit.service.CwiczenieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Cwiczenie> createCwiczenie(@RequestBody Cwiczenie cwiczenie) {
        return cwiczenieService.createCwiczenie(cwiczenie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCwiczenie(@PathVariable Long id) {
        return cwiczenieService.deleteCwiczenie(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cwiczenie> updateCwiczenie(@PathVariable Long id, @RequestBody Cwiczenie updatedCwiczenie) {
        return cwiczenieService.updateCwiczenie(id, updatedCwiczenie);
    }
}
