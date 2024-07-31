package com.dmc.bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan(basePackages = "com.dmc.bootcamp.domain")
public class DMCApplication {
    public  static void main(String[] args){
        SpringApplication.run(DMCApplication.class,args);
    }
}
