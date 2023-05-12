package com.grupodos.producto4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Producto4Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Producto4Application.class, args);
        System.out.println("\nI am ready to serve!");
    }
    
}

