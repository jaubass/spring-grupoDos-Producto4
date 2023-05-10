package com.GrupoDos.producto4.controller;

import com.GrupoDos.producto4.model.MenuItem;
import com.GrupoDos.producto4.repository.MenuItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MenuItemController {

    public MenuItemRepository repo;

    public MenuItemController(MenuItemRepository repo) {
        this.repo = repo;
    }

    // CRUD
    @GetMapping("/api/menu")
    public List<MenuItem> findAll() {
        return repo.findAll();
    }

    @GetMapping("/api/menu/{id}")
    public ResponseEntity<MenuItem> findOneById(@PathVariable Long id) {
        Optional<MenuItem> itemOpt = repo.findById(id);
        if (itemOpt.isPresent()) {
            return ResponseEntity.ok(itemOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

