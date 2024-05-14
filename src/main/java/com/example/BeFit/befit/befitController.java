package com.example.BeFit.befit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/befit")
public class befitController {

    private final befitService befitService;
    @Autowired
    public befitController(befitService befitService) {
        this.befitService = befitService;
    }
    @GetMapping
    public List<befit> befit(){
        return befitService.befit();
    }
}
