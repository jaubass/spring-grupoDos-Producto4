package com.grupodos.producto4.repository;

import com.grupodos.producto4.model.Brand;
import com.grupodos.producto4.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "vehicles", collectionResourceRel = "vehicles", itemResourceRel = "vehicle")
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByBrandIn(List<Brand> brandList);
}
