package com.GrupoDos.producto4.controller;

import com.GrupoDos.producto4.model.Restaurant;
import com.GrupoDos.producto4.repository.RestaurantRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class RestaurantController {

    private static Logger log = LoggerFactory.getLogger(RestaurantController.class);

    public RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }


    // CRUD


    // Buscar todos los users
    @GetMapping("/api/Restaurants")
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }
}