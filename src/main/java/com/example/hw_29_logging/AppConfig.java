package com.example.hw_29_logging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class AppConfig {

    @Bean
    Random random() {
        return new Random();
    }
}
