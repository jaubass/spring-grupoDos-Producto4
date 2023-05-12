package com.grupodos.producto4.repository;

import com.grupodos.producto4.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "restaurants", collectionResourceRel = "restaurants", itemResourceRel = "restaurant")
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
