package com.GrupoDos.producto4.repository;
import com.GrupoDos.producto4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.GrupoDos.producto4.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}


