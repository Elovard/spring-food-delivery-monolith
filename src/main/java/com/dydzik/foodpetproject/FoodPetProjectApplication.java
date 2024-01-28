package com.dydzik.foodpetproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(exclude = {
    UserDetailsServiceAutoConfiguration.class
})
@EnableJpaAuditing
public class FoodPetProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodPetProjectApplication.class, args);
    }

}
