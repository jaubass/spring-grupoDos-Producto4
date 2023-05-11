package com.GrupoDos.producto4.controller;

import com.GrupoDos.producto4.model.Restaurant;
import com.GrupoDos.producto4.repository.RestaurantRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class RestaurantController {

    private static Logger log = LoggerFactory.getLogger(RestaurantController.class);

    public RestaurantRepository restaurantRepo;

    public RestaurantController(RestaurantRepository restaurantRepo) {
        this.restaurantRepo = restaurantRepo;
    }


    // CRUD
    @GetMapping("/api/restaurants")
    public List<Restaurant> findAll() {
        return restaurantRepo.findAll();
    }

    @GetMapping("/api/restaurants/{id}")
    public ResponseEntity<Restaurant> findOneById(@PathVariable Long id) {
        Optional<Restaurant> restOpt = restaurantRepo.findById(id);
        if (restOpt.isPresent()) {
            return ResponseEntity.ok(restOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}