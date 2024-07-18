package com.dmc.bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DMCApplication {
    public  static void main(String[] args){
        SpringApplication.run(DMCApplication.class,args);
    }
}
