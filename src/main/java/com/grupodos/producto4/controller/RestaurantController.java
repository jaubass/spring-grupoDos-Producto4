package com.grupodos.producto4.controller;

import com.grupodos.producto4.model.Restaurant;
import com.grupodos.producto4.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantRepository restaurants;

    @GetMapping("")
    public ResponseEntity<List<Restaurant>> all() {
        return ok(this.restaurants.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> get(@PathVariable("id") Long id) {
        return ok(this.restaurants.findById(id).orElseThrow(() -> new VehicleNotFoundException()));
    }

}
