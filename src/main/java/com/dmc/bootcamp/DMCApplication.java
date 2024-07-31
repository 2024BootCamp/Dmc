package com.dmc.bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.boot.autoconfigure.domain.EntityScan;
=======
>>>>>>> 235a33fcc00776f3ec31e1eb0513a0160fbc4608
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
<<<<<<< HEAD
@EntityScan(basePackages = "com.dmc.bootcamp.domain")
=======
>>>>>>> 235a33fcc00776f3ec31e1eb0513a0160fbc4608
public class DMCApplication {
    public  static void main(String[] args){
        SpringApplication.run(DMCApplication.class,args);
    }
}
