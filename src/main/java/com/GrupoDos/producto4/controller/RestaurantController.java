package com.GrupoDos.producto4.controller;

import com.GrupoDos.producto4.model.Restaurant;
import com.GrupoDos.producto4.model.User;
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

    // Buscar todos los Restaurantes
    @GetMapping("/api/restaurants")
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }
    
    @PostMapping("/api/restaurants")
    public ResponseEntity<Restaurant> create(@RequestBody Restaurant restaurant, @RequestHeader HttpHeaders headers) {
       System.out.println(headers.get("User-Agent"));
       if(restaurant.getId() != null) {
            log.warn("Trying to create a Restaurant with id");
            return ResponseEntity.badRequest().build();
       }
        Restaurant result = restaurantRepository.save(restaurant);
        return ResponseEntity.ok(result);
    }
    
    @DeleteMapping("/api/restaurants/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id) {

        if (!restaurantRepository.existsById(id)) {
            log.warn("Trying to delete a non existent restaurant");
            return ResponseEntity.notFound().build();
        }

        restaurantRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    


        
}