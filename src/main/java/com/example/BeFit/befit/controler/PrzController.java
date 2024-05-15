package com.example.BeFit.befit.controler;

import com.example.BeFit.befit.model.Przepis;
import com.example.BeFit.befit.repository.PrzepisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PrzController {

    @Autowired
    private PrzepisRepository przepisRepository;

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<List<Przepis>> getAllPrzepisy() {
        List<Przepis> przepisy = przepisRepository.findAll();
        return new ResponseEntity<>(przepisy, HttpStatus.OK);
    }
}
