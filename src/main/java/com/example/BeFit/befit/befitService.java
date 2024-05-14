package com.example.BeFit.befit;


import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class befitService {

    public List<befit> befit(){
        return List.of(new befit(
                1L,
                "asd",
                "asd",
                "asd"
        ));
    }
}
