package com.springprofileswithspringboot.springbootprofiles.Configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Profile("dev")
@Configuration
public class javaconfiguration {


    @PostConstruct
    public void test(){
        System.out.println("Loaded DEV Environment");


    }
}
