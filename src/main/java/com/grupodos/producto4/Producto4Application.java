package com.grupodos.producto4;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
@OpenAPIDefinition(info = @Info(
        title = "Para casa! by Grupodos",
        version = "4.0",
    description = "API backend para un servicio de comidas a domicilio de restaurantes italianos.<br>Producto 4. Aplicación back-end con Java en servidores de aplicaciones."
))
public class Producto4Application {

    public static void main(String[] args) {
        SpringApplication.run(Producto4Application.class, args);
        System.out.println("\nI am ready to serve!");
    }

}

