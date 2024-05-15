package com.example.BeFit.befit.controler;

import com.example.BeFit.befit.model.Przepis;
import com.example.BeFit.befit.service.PrzepisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/przepisy")
public class PrzepisController {
    @Autowired
    private PrzepisService przepisService;

    @GetMapping
    public List<Przepis> getAllPrzepisy() {
        return przepisService.getAllPrzepisy();
    }

    @GetMapping("/{id}")
    public Przepis getPrzepisById(@PathVariable Long id) {
        return przepisService.getPrzepisById(id);
    }

    @PostMapping
    public Przepis savePrzepis(@RequestBody Przepis przepis) {
        return przepisService.savePrzepis(przepis);
    }
}
