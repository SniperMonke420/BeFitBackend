package com.example.BeFit;

import com.example.BeFit.befit.model.Przepis;
import com.example.BeFit.befit.repository.PrzepisRepository;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class PrzepisyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrzepisyApplication.class, args);
	}



}
