package com.grupodos.producto4.repository;

import com.grupodos.producto4.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "menu", collectionResourceRel = "menu", itemResourceRel = "menuitem")
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
