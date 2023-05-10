package com.GrupoDos.producto4.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.GrupoDos.producto4.model.Restaurant;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}


