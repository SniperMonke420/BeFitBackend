package com.example.BeFit;

import com.befit.befit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController

public class BeFitApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeFitApplication.class, args);
		//asdasdasvcbcvbc
	}
	@GetMapping
	public List<befit> hello(){
		return List.of(new befit(
				1L,
				"asd",
				"asd",
				"asd"
		));
	}
}
