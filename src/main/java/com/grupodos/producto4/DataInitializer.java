package com.grupodos.producto4;

import com.grupodos.producto4.model.User;
import com.grupodos.producto4.model.Vehicle;
import com.grupodos.producto4.repository.RestaurantRepository;
import com.grupodos.producto4.repository.UserRepository;
import com.grupodos.producto4.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Slf4j
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    
    private final VehicleRepository vehicles;
    
    private final UserRepository users;
    
    private final PasswordEncoder passwordEncoder;

    private final RestaurantRepository restaurantRepo;
    
    @Override
    public void run(String... args) {
        log.debug("initializing vehicles data...");
        Arrays.asList("moto", "car").forEach(v -> this.vehicles.saveAndFlush(Vehicle.builder().name(v).build()));
        
        log.debug("printing all vehicles...");
        this.vehicles.findAll().forEach(v -> log.debug(" Vehicle :" + v.toString()));
        
        this.users.save(User.builder()
                .username("user")
                .password(this.passwordEncoder.encode("password"))
                .roles(Arrays.asList("ROLE_USER"))
                .build()
        );
        
        this.users.save(User.builder()
                .username("admin")
                .password(this.passwordEncoder.encode("password"))
                .roles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"))
                .build()
        );
        
        log.debug("printing all users...");
        this.users.findAll().forEach(v -> log.debug(" User :" + v.toString()));

        // Add Restaurants to database
    }
}
